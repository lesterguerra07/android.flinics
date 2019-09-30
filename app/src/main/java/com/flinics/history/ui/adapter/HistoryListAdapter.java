package com.flinics.history.ui.adapter;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.flinics.history.BuildConfig;
import com.flinics.history.R;
import com.flinics.history.Volley;
import com.flinics.history.WizardActivity;
import com.flinics.history.ui.model.History;

import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.HistoryHolder> {

    private ArrayList<History> _historyList;
    private Context _context;
    private String _accessToken;

    private File file;
    private long downloadID;

    public HistoryListAdapter(ArrayList<History> HistoryList, Context context, String accessToken) {
        _historyList = HistoryList;
        _context = context;
        _accessToken = accessToken;
    }

    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        // Inflate the layout view you have created for the list rows here
        View view = layoutInflater.inflate(R.layout.layout_history_item, parent, false);
        return new HistoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryHolder holder, final int position) {
        final History history = _historyList.get(position);

        _context.registerReceiver(onDownloadComplete,new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

        holder.setHistoryTitle(history.getName());
        holder.setHistorySubtitle(history.getDescription());

        holder.btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WizardActivity.class);
                // TODO: pass parameters name to string resources
                intent.putExtra("accessToken", _accessToken);
                intent.putExtra("historyId", history.getId());
                _context.startActivity(intent);
            }
        });

        holder.btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginDownload(history.getId());
            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(_context, "Eliminando...", Toast.LENGTH_SHORT).show();
                _historyList.remove(position);
                Volley.deleteData(_context, null, successDeleteDataListener, errorDeleteDataListener, "1", "history", history.getId(), _accessToken);
            }
        });
    }

    @Override
    public int getItemCount() {
        return _historyList == null? 0: _historyList.size();
    }

    private BroadcastReceiver onDownloadComplete = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //Fetching the download id received with the broadcast
            long id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
            //Checking if the received broadcast is for our enqueued download by matching download id
            if (downloadID == id) {
                // TODO: pass text to string resources
                Toast.makeText(_context, "Descarga Completa", Toast.LENGTH_SHORT).show();
                openFile();
            }
        }
    };

    // See: https://stackoverflow.com/questions/36766483/after-download-how-to-open-downloaded-file
    // Also: https://inthecheesefactory.com/blog/how-to-share-access-to-file-with-fileprovider-on-android-nougat/en
    private void openFile() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        Uri fileURI = FileProvider.getUriForFile(_context,
                BuildConfig.APPLICATION_ID + ".provider",
                file);
        intent.setDataAndType(fileURI,
                "application/pdf");
        _context.startActivity(intent);
    }

    // See: https://androidclarified.com/android-downloadmanager-example/
    private void beginDownload( String historyId){
        // TODO: pass text to string resources
        Toast.makeText(_context, "Descargando...", Toast.LENGTH_SHORT).show();
        // TODO: pass Flinics name to string resources
        String fileName = "Flinics." + UUID.randomUUID().toString() + ".pdf";
        file = new File(_context.getExternalFilesDir(null),fileName);

        // TODO: pass url text, title and description to string resources
        DownloadManager.Request request=new DownloadManager.Request(Uri.parse("https://api.flinics.brickapps.com/v1/file/" + historyId))
                .setTitle("Historia Clínica")
                .setDescription("Descargando")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setDestinationUri(Uri.fromFile(file))
                .setAllowedOverMetered(true)
                .setAllowedOverRoaming(true)
                .addRequestHeader("authorization", "Bearer " + _accessToken);
        DownloadManager downloadManager= (DownloadManager) _context.getSystemService(_context.DOWNLOAD_SERVICE);
        downloadID = downloadManager.enqueue(request);
    }

    private Response.Listener<JSONObject> successDeleteDataListener = new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            // Log.d("MainActivity", response.toString());
            notifyDataSetChanged();
            Toast.makeText(_context, "Historia eliminada exitosamente!", Toast.LENGTH_SHORT).show();
        }
    };

    private Response.ErrorListener errorDeleteDataListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            // Log.e("WizardActivity", error.toString());
        }
    };

    public class HistoryHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private TextView tvSubtitle;
        private Button btnDelete;
        private Button btnDownload;
        private Button btnView;

        public HistoryHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.title_TView);
            tvSubtitle = itemView.findViewById(R.id.subtitle_TView);
            btnDelete = itemView.findViewById(R.id.delete_Button);
            btnDownload = itemView.findViewById(R.id.download_Button);
            btnView = itemView.findViewById(R.id.rectify_Button);
        }

        public void setHistoryTitle(String title) {
            tvTitle.setText(title);
        }

        public void setHistorySubtitle(String subtitle) {
            tvSubtitle.setText(subtitle);
        }
    }
}

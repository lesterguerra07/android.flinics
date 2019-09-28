package com.flinics.history;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private String accessToken = "";
    private File file;
    private long downloadID;

    private BroadcastReceiver onDownloadComplete = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //Fetching the download id received with the broadcast
            long id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
            //Checking if the received broadcast is for our enqueued download by matching download id
            if (downloadID == id) {
                Toast.makeText(MainActivity.this, "Descarga Completa", Toast.LENGTH_SHORT).show();
                openFile();
            }
        }
    };

    // See: https://stackoverflow.com/questions/36766483/after-download-how-to-open-downloaded-file
    // Also: https://inthecheesefactory.com/blog/how-to-share-access-to-file-with-fileprovider-on-android-nougat/en
    private void openFile() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        Uri fileURI = FileProvider.getUriForFile(MainActivity.this,
                BuildConfig.APPLICATION_ID + ".provider",
                file);
        intent.setDataAndType(fileURI,
                "application/pdf");
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        accessToken = intent.getStringExtra("accessToken");

        FloatingActionButton fab = findViewById(R.id.preview_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WizardActivity.class);
                intent.putExtra("accessToken", accessToken);
                intent.putExtra("historyId", "5d8e7730c6b4924b0dac2710");// Optional
                startActivity(intent);
            }
        });

        registerReceiver(onDownloadComplete,new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

        final Button patientsButton = findViewById(R.id.patient_button);
        patientsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beginDownload();
            }
        });
    }

    // See: https://androidclarified.com/android-downloadmanager-example/
    private void beginDownload(){
        Toast.makeText(MainActivity.this, "Descargando...", Toast.LENGTH_SHORT).show();
        String fileName = "Flinics." + UUID.randomUUID().toString() + ".pdf";
        file = new File(getExternalFilesDir(null),fileName);

        DownloadManager.Request request=new DownloadManager.Request(Uri.parse("https://api.flinics.brickapps.com/v1/file/5d8a642502b9f21045750b8c"))
                .setTitle("Historia Clínica")
                .setDescription("Descargando")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setDestinationUri(Uri.fromFile(file))
                .setAllowedOverMetered(true)
                .setAllowedOverRoaming(true)
                .addRequestHeader("authorization", "Bearer " + accessToken);
        DownloadManager downloadManager= (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        downloadID = downloadManager.enqueue(request);
    }

}

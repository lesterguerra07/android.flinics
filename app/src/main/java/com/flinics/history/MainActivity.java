package com.flinics.history;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.flinics.history.ui.adapter.HistoryListAdapter;
import com.flinics.history.ui.model.History;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private String accessToken = "";
    private String userId = "";

    private HistoryListAdapter listAdapter;
    private ArrayList<History> HistoryList = new ArrayList<>();
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Getting accessToken
        Intent intent = getIntent();
        accessToken = intent.getStringExtra("accessToken");
        userId = intent.getStringExtra("userId");

        FloatingActionButton fab = findViewById(R.id.preview_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WizardActivity.class);
                intent.putExtra("accessToken", accessToken);
                startActivity(intent);
            }
        });

        recycler = findViewById(R.id.historyList_RView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        listAdapter = new HistoryListAdapter(HistoryList, this, accessToken);
        recycler.addItemDecoration(new DividerItemDecoration(this,
                layoutManager.getOrientation()));
        recycler.setAdapter(listAdapter);

        getHistoryList();

    }

    private void getHistoryList(){
        Volley.getData(this, null, successGetDataListener, errorGetDataListener, "1", "history/user/minified", userId, accessToken);

    }

    private Response.Listener<JSONObject> successGetDataListener = new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            try {
                Log.d("MainActivity", response.toString());
                HashMap<String, ArrayList<HashMap>> historyData = new Gson().fromJson(response.toString(), new TypeToken<HashMap<String, ArrayList<HashMap>>>(){}.getType());
                ArrayList<HashMap> historyList = historyData.get("histories");
                if (historyList != null){
                    for (HashMap historyItem : historyList){
                        String id = (String) historyItem.get("_id");
                        String name = "";
                        String gender = "";
                        String age = "";
                        ArrayList nameObject = (ArrayList)historyItem.get("giName");
                        if (nameObject.size() > 0){
                            name = (String)((LinkedTreeMap) nameObject.get(nameObject.size() - 1)).get("value");
                        }
                        ArrayList genderObject = (ArrayList)historyItem.get("giGender");
                        if (genderObject.size() > 0){
                            gender = (String)((LinkedTreeMap) genderObject.get(genderObject.size() - 1)).get("value");
                        }
                        ArrayList ageObject = (ArrayList)historyItem.get("giAge");
                        if (ageObject.size() > 0){
                            age = (String)((LinkedTreeMap) ageObject.get(ageObject.size() - 1)).get("value");
                        }
                        HistoryList.add(new History(id,name, gender, age));
                    }
                    listAdapter.notifyDataSetChanged();
                }
            } catch (Exception e){
                Log.e("MainActivity", e.getStackTrace().toString());
            }



        }
    };

    private Response.ErrorListener errorGetDataListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("WizardActivity", error.toString());
        }
    };

}

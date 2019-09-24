package com.flinics.history;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.flinics.history.data.model.ClinicHistoryModel;
import com.flinics.history.ui.main.SectionsPagerAdapter;
import com.flinics.history.view_model.WizardViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONObject;

import java.util.HashMap;

public class WizardActivity extends AppCompatActivity {
    FloatingActionButton fab_mic;
    FloatingActionButton fab_done;
    ViewPager viewPager;
    SectionsPagerAdapter sectionsPagerAdapter;
    private WizardViewModel _wizardViewModel;

    private HashMap<String, String> data;

    private String _accessToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wizard);

        Intent intent = getIntent();
        _accessToken =  intent.getStringExtra("accessToken");

        _wizardViewModel = ViewModelProviders.of(this).get(WizardViewModel.class);

        data = new HashMap<>();

        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(), data);
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        fab_mic = findViewById(R.id.mic_fab);
        fab_done = findViewById(R.id.done_fab);

        fab_mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        fab_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    sendData();
                } catch (Exception exception) {
                    Log.e("WizardActivity", "Error sending data", exception);
                }
            }
        });

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == sectionsPagerAdapter.getCount() - 1)
                    fab_done.show();
                else
                    fab_done.hide();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void sendData() {
        ClinicHistoryModel data = _wizardViewModel.getClinicHistory();
        Volley.postData(this, data.toJSONObject(), successListener, errorListener, "1", "history", "", _accessToken);
    }

    private Response.Listener<JSONObject> successListener = new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            Log.d("WizardActivity", response.toString());
        }
    };

    private Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("WizardActivity", error.toString());
        }
    };
}
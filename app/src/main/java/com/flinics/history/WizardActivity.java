package com.flinics.history;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WizardActivity extends AppCompatActivity {
    private Context context;
    FloatingActionButton fab_mic;
    FloatingActionButton fab_done;
    ViewPager viewPager;
    SectionsPagerAdapter sectionsPagerAdapter;
    private WizardViewModel _wizardViewModel;
    private ClinicHistoryModel _originalData;

    private String _accessToken;
    private String _historyId;

    private final int REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wizard);

        context = this;

        Intent intent = getIntent();
        _accessToken =  intent.getStringExtra("accessToken");
        _historyId =  intent.getStringExtra("historyId");

        _wizardViewModel = ViewModelProviders.of(this).get(WizardViewModel.class);

        if(_historyId != null && _historyId.trim() != ""){
            _wizardViewModel.setId(_historyId);
            getData();
        } else{
            iniFragment();
        }

        fab_mic = findViewById(R.id.mic_fab);
        fab_done = findViewById(R.id.done_fab);


        fab_mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "es-US");
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Habla ahora");
                try {
                    startActivityForResult(intent, REQ_CODE);
                } catch (ActivityNotFoundException a) {
                    Snackbar.make(view, "Lo sentimos, tu dispositivo no es compatible.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

            }
        });

        fab_done.hide();

        fab_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(_historyId != null && _historyId != ""){
                        putData();
                    } else {
                        postData();
                    }
                } catch (Exception exception) {
                    // Log.e("WizardActivity", "Error sending data", exception);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQ_CODE: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    View currentFocusedView = this.getCurrentFocus();

                    EditText currentEditText = findViewById(currentFocusedView.getId());

                    currentEditText.setText(result.get(0).toString());
                }
                break;
            }
        }
    }

    private void postData() {
        ClinicHistoryModel data = _wizardViewModel.getClinicHistory();
        Volley.postData(this, data.toJSONObject(), successSendDataListener, errorSendDataListener, "1", "history", "", _accessToken);
    }

    private void putData() {
        ClinicHistoryModel data = _wizardViewModel.getClinicHistory();
        HashMap<String, ArrayList<ClinicHistoryModel.FieldModel>> newData = data.getClinicHistory();
        HashMap<String, ArrayList<ClinicHistoryModel.FieldModel>> originalData = _originalData.getClinicHistory();
        for(Map.Entry<String, ArrayList<ClinicHistoryModel.FieldModel>> item : _originalData.getClinicHistory().entrySet()){
            String key = item.getKey();
            ArrayList<ClinicHistoryModel.FieldModel> newInfo = newData.get(key);
            ArrayList<ClinicHistoryModel.FieldModel> originalInfo = originalData.get(key);
            String originalValue = originalInfo.get(originalInfo.size()-1).value;
            String newValue = newInfo.get(0).value;
            if(!newValue.equals(originalValue)){
                _originalData.setNewData(key, newInfo.get(0).value);
            }
        }
        Volley.putData(this, _originalData.toJSONObject(), successPutDataListener, errorPutDataListener, "1", "history", _historyId, _accessToken);
    }

    private Response.Listener<JSONObject> successPutDataListener = new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            // Log.d("WizardActivity", response.toString());
            Toast.makeText(context, "Historia rectificada exitosamente!", Toast.LENGTH_SHORT).show();
            finish();

        }
    };

    private Response.ErrorListener errorPutDataListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            // Log.e("WizardActivity", error.toString());
        }
    };

    private Response.Listener<JSONObject> successSendDataListener = new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            // Log.d("WizardActivity", response.toString());
            Toast.makeText(context, "Historia creada exitosamente!", Toast.LENGTH_SHORT).show();
            finish();

        }
    };

    private Response.ErrorListener errorSendDataListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            // Log.e("WizardActivity", error.toString());
        }
    };

    private void getData() {
        ClinicHistoryModel data = _wizardViewModel.getClinicHistory();
        Volley.getData(this, null, successGetDataListener, errorGetDataListener, "1", "history", _historyId, _accessToken);
    }

    private Response.Listener<JSONObject> successGetDataListener = new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            // Log.d("WizardActivity", response.toString());
            HashMap<String, ArrayList<ClinicHistoryModel.FieldModel>> clinicHistory = new Gson().fromJson(response.toString(), new TypeToken<HashMap<String, ArrayList<ClinicHistoryModel.FieldModel>>>(){}.getType());
            _wizardViewModel.setClinicHistory(new ClinicHistoryModel(clinicHistory));
            _originalData = new ClinicHistoryModel((HashMap<String, ArrayList<ClinicHistoryModel.FieldModel>>)clinicHistory.clone());
            for(Map.Entry<String, ArrayList<ClinicHistoryModel.FieldModel>> originalArray : _originalData.getClinicHistory().entrySet()){
                ArrayList<ClinicHistoryModel.FieldModel> originalArrayCopy = new ArrayList<>();
                for(ClinicHistoryModel.FieldModel originalField : originalArray.getValue()){
                    originalArrayCopy.add(new ClinicHistoryModel.FieldModel(originalField.value, originalField.version));
                }
                _originalData.getClinicHistory().put(originalArray.getKey(), originalArrayCopy);
            }
            iniFragment();
        }
    };

    private Response.ErrorListener errorGetDataListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            // Log.e("WizardActivity", error.toString());
        }
    };

    protected void iniFragment(){
        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

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

}
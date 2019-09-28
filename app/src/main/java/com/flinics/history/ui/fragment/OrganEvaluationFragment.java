package com.flinics.history.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.flinics.history.R;
import com.flinics.history.data.model.ClinicHistoryModel;
import com.flinics.history.interfaces.IWizardAction;
import com.flinics.history.utils.HistoryUtil;
import com.flinics.history.view_model.WizardViewModel;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OrganEvaluationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OrganEvaluationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrganEvaluationFragment extends Fragment implements IWizardAction {

    private WizardViewModel wizardViewModel;
    private OnFragmentInteractionListener mListener;

    // UI Elements
    protected EditText etSkinAndFaneras;
    protected EditText etHead;
    protected EditText etEyes;
    protected EditText etEars;
    protected EditText etNose;
    protected EditText etOropharynx;
    protected EditText etNeck;
    protected EditText etChest;
    protected EditText etAbdomen;
    protected EditText etLumbarRegion;
    protected EditText etExtremities;
    protected EditText etNeurological;

    public OrganEvaluationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment OrganEvaluationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrganEvaluationFragment newInstance() {
        OrganEvaluationFragment fragment = new OrganEvaluationFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wizardViewModel = ViewModelProviders.of(this.getActivity()).get(WizardViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_organ_evaluation, container, false);
        initComponents(view);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public  void onPause() {
        super.onPause();
        saveInfo();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void displayInfo(ClinicHistoryModel data) {
        etSkinAndFaneras.setText(data.getLastData(HistoryUtil.oeSkinAndFaneras.value).value);
        etHead.setText(data.getLastData(HistoryUtil.oeHead.value).value);
        etEyes.setText(data.getLastData(HistoryUtil.oeEyes.value).value);
        etEars.setText(data.getLastData(HistoryUtil.oeEars.value).value);
        etNose.setText(data.getLastData(HistoryUtil.oeNose.value).value);
        etOropharynx.setText(data.getLastData(HistoryUtil.oeOropharynx.value).value);
        etNeck.setText(data.getLastData(HistoryUtil.oeNeck.value).value);
        etChest.setText(data.getLastData(HistoryUtil.oeChest.value).value);
        etAbdomen.setText(data.getLastData(HistoryUtil.oeAbdomen.value).value);
        etLumbarRegion.setText(data.getLastData(HistoryUtil.oeLumbarRegion.value).value);
        etExtremities.setText(data.getLastData(HistoryUtil.oeExtremities.value).value);
        etNeurological.setText(data.getLastData(HistoryUtil.oeNeurological.value).value);
    }

    @Override
    public void saveInfo() {
        wizardViewModel.setOrganEvaluation(
                etSkinAndFaneras.getText().toString(),
                etHead.getText().toString(),
                etEyes.getText().toString(),
                etEars.getText().toString(),
                etNose.getText().toString(),
                etOropharynx.getText().toString(),
                etNeck.getText().toString(),
                etChest.getText().toString(),
                etAbdomen.getText().toString(),
                etLumbarRegion.getText().toString(),
                etExtremities.getText().toString(),
                etNeurological.getText().toString()
        );
    }

    @Override
    public void initComponents(View view) {
        etSkinAndFaneras = view.findViewById(R.id.skinAndFaneras_EText);
        etSkinAndFaneras.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                saveInfo();
            }
        });
        etHead = view.findViewById(R.id.head_EText);
        etHead.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                saveInfo();
            }
        });
        etEyes = view.findViewById(R.id.eyes_EText);
        etEyes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                saveInfo();
            }
        });
        etEars = view.findViewById(R.id.ears_EText);
        etEars.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                saveInfo();
            }
        });
        etNose = view.findViewById(R.id.nose_EText);
        etNose.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                saveInfo();
            }
        });
        etOropharynx = view.findViewById(R.id.oropharynx_EText);
        etOropharynx.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                saveInfo();
            }
        });
        etNeck = view.findViewById(R.id.neck_EText);
        etNeck.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                saveInfo();
            }
        });
        etChest = view.findViewById(R.id.chest_EText);
        etChest.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                saveInfo();
            }
        });
        etAbdomen = view.findViewById(R.id.abdomen_EText);
        etAbdomen.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                saveInfo();
            }
        });
        etLumbarRegion = view.findViewById(R.id.lumbarRegion_EText);
        etLumbarRegion.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                saveInfo();
            }
        });
        etExtremities = view.findViewById(R.id.extremities_EText);
        etExtremities.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                saveInfo();
            }
        });
        etNeurological = view.findViewById(R.id.neurological_EText);
        etNeurological.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                saveInfo();
            }
        });
        displayInfo(wizardViewModel.getClinicHistory());
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

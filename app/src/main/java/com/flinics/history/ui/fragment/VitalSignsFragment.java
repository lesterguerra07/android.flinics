package com.flinics.history.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
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
 * {@link VitalSignsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VitalSignsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VitalSignsFragment extends Fragment implements IWizardAction {

    private WizardViewModel wizardViewModel;
    private OnFragmentInteractionListener mListener;

    // UI Elements
    protected EditText etTemperature;
    protected EditText etBloodPressureLeft;
    protected EditText etBloodPressureRight;
    protected EditText etHeartRate;
    protected EditText etPulseRate;
    protected EditText etBreathingFrequency;

    public VitalSignsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment VitalSignsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VitalSignsFragment newInstance() {
        VitalSignsFragment fragment = new VitalSignsFragment();
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
        View view =  inflater.inflate(R.layout.fragment_vital_signs, container, false);
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
        etTemperature.setText(data.getLastData(HistoryUtil.vsTemperature.value).value);
        etBloodPressureLeft.setText(data.getLastData(HistoryUtil.vsBloodPressureLeft.value).value);
        etBloodPressureRight.setText(data.getLastData(HistoryUtil.vsBloodPressureRight.value).value);
        etHeartRate.setText(data.getLastData(HistoryUtil.vsHeartRate.value).value);
        etPulseRate.setText(data.getLastData(HistoryUtil.vsPulseRate.value).value);
        etBreathingFrequency.setText(data.getLastData(HistoryUtil.vsBreathingFrequency.value).value);
    }

    @Override
    public void saveInfo() {
        wizardViewModel.setVitalSign(
                etTemperature.getText().toString(),
                etBloodPressureLeft.getText().toString(),
                etBloodPressureRight.getText().toString(),
                etHeartRate.getText().toString(),
                etPulseRate.getText().toString(),
                etBreathingFrequency.getText().toString()
        );
    }

    @Override
    public void initComponents(View view) {
        etTemperature = view.findViewById(R.id.temperature_EText);
        etBloodPressureLeft = view.findViewById(R.id.bloodPressureLeft_EText);
        etBloodPressureRight = view.findViewById(R.id.bloodPressureRight_EText);
        etHeartRate = view.findViewById(R.id.heartRate_EText);
        etPulseRate = view.findViewById(R.id.pulseRate_EText);
        etBreathingFrequency = view.findViewById(R.id.breathingFrequency_EText);
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

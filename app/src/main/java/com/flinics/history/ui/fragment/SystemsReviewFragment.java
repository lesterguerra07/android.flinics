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
 * {@link SystemsReviewFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SystemsReviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SystemsReviewFragment extends Fragment implements IWizardAction {

    private WizardViewModel wizardViewModel;
    private OnFragmentInteractionListener mListener;

    // UI Elements
    protected EditText etConduct;
    protected EditText etSkinAndFaneras;
    protected EditText etHead;
    protected EditText etEyes;
    protected EditText etNose;
    protected EditText etMouth;
    protected EditText etThroat;
    protected EditText etNeck;
    protected EditText etMammaryLand;
    protected EditText etLymphaticSystem;
    protected EditText etRespiratorySystem;
    protected EditText etCardiovascularSystem;
    protected EditText etDigestiveSystem;
    protected EditText etGenotourinarySystem;
    protected EditText etEndocrineSystem;
    protected EditText etSkeletalMuscleSystem;
    protected EditText etNervousSystem;


    public SystemsReviewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment SystemsReviewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SystemsReviewFragment newInstance() {
        SystemsReviewFragment fragment = new SystemsReviewFragment();
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
        View view = inflater.inflate(R.layout.fragment_systems_review, container, false);
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
        etConduct.setText(data.getLastData(HistoryUtil.srConduct.value).value);
        etSkinAndFaneras.setText(data.getLastData(HistoryUtil.srSkinAndFaneras.value).value);
        etHead.setText(data.getLastData(HistoryUtil.srHead.value).value);
        etEyes.setText(data.getLastData(HistoryUtil.srEyes.value).value);
        etNose.setText(data.getLastData(HistoryUtil.srNose.value).value);
        etMouth.setText(data.getLastData(HistoryUtil.srMouth.value).value);
        etThroat.setText(data.getLastData(HistoryUtil.srThroat.value).value);
        etNeck.setText(data.getLastData(HistoryUtil.srNeck.value).value);
        etMammaryLand.setText(data.getLastData(HistoryUtil.srMammaryLand.value).value);
        etLymphaticSystem.setText(data.getLastData(HistoryUtil.srLymphaticSystem.value).value);
        etRespiratorySystem.setText(data.getLastData(HistoryUtil.srRespiratorySystem.value).value);
        etCardiovascularSystem.setText(data.getLastData(HistoryUtil.srCardiovascularSystem.value).value);
        etDigestiveSystem.setText(data.getLastData(HistoryUtil.srDigestiveSystem.value).value);
        etGenotourinarySystem.setText(data.getLastData(HistoryUtil.srGenotourinarySystem.value).value);
        etEndocrineSystem.setText(data.getLastData(HistoryUtil.srEndocrineSystem.value).value);
        etSkeletalMuscleSystem.setText(data.getLastData(HistoryUtil.srSkeletalMuscleSystem.value).value);
        etNervousSystem.setText(data.getLastData(HistoryUtil.srNervousSystem.value).value);
    }

    @Override
    public void saveInfo() {
        wizardViewModel.setSystemsReview(
                etConduct.getText().toString(),
                etSkinAndFaneras.getText().toString(),
                etHead.getText().toString(),
                etEyes.getText().toString(),
                etNose.getText().toString(),
                etMouth.getText().toString(),
                etThroat.getText().toString(),
                etNeck.getText().toString(),
                etMammaryLand.getText().toString(),
                etLymphaticSystem.getText().toString(),
                etRespiratorySystem.getText().toString(),
                etCardiovascularSystem.getText().toString(),
                etDigestiveSystem.getText().toString(),
                etGenotourinarySystem.getText().toString(),
                etEndocrineSystem.getText().toString(),
                etSkeletalMuscleSystem.getText().toString(),
                etNervousSystem.getText().toString());
    }

    @Override
    public void initComponents(View view) {
        etConduct = view.findViewById(R.id.conduct_EText);
        etSkinAndFaneras = view.findViewById(R.id.skinAndFaneras_EText);
        etHead = view.findViewById(R.id.head_EText);
        etEyes = view.findViewById(R.id.eyes_EText);
        etNose = view.findViewById(R.id.nose_EText);
        etMouth = view.findViewById(R.id.mouth_EText);
        etThroat = view.findViewById(R.id.throat_EText);
        etNeck = view.findViewById(R.id.neck_EText);
        etMammaryLand = view.findViewById(R.id.mammaryLand_EText);
        etLymphaticSystem = view.findViewById(R.id.lymphaticSystem_EText);
        etRespiratorySystem = view.findViewById(R.id.respiratorySystem_EText);
        etCardiovascularSystem = view.findViewById(R.id.cardiovascularSystem_EText);
        etDigestiveSystem = view.findViewById(R.id.digestiveSystem_EText);
        etGenotourinarySystem = view.findViewById(R.id.genotourinarySystem_EText);
        etEndocrineSystem = view.findViewById(R.id.endocrineSystem_EText);
        etSkeletalMuscleSystem = view.findViewById(R.id.skeletalMuscleSystem_EText);
        etNervousSystem = view.findViewById(R.id.nervousSystem_EText);
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

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
 * {@link NoPathologicalHistoryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NoPathologicalHistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoPathologicalHistoryFragment extends Fragment implements IWizardAction {

    private WizardViewModel wizardViewModel;
    private OnFragmentInteractionListener mListener;

    // UI Elements
    protected EditText etPrenatalPeriod;
    protected EditText etNataPeriod;
    protected EditText etPosnatalPeriod;
    protected EditText etImmunizations;
    protected EditText etNutrition;
    protected EditText etHabits;
    protected EditText etMenarquia;
    protected EditText etMenstrualCycle;
    protected EditText etLastMenstruation;
    protected EditText etContraceptiveMethods;
    protected EditText etGestation;
    protected EditText etParturitions;
    protected EditText etLivingChildren;

    public NoPathologicalHistoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment NoPathologicalHistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NoPathologicalHistoryFragment newInstance() {
        NoPathologicalHistoryFragment fragment = new NoPathologicalHistoryFragment();
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
        View view =  inflater.inflate(R.layout.fragment_no_pathological_history, container, false);
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
        etPrenatalPeriod.setText(data.getLastData(HistoryUtil.nphPrenatalPeriod.value).value);
        etNataPeriod.setText(data.getLastData(HistoryUtil.nphNataPeriod.value).value);
        etPosnatalPeriod.setText(data.getLastData(HistoryUtil.nphPostnatalPeriod.value).value);
        etImmunizations.setText(data.getLastData(HistoryUtil.nphImmunizations.value).value);
        etNutrition.setText(data.getLastData(HistoryUtil.nphNutrition.value).value);
        etHabits.setText(data.getLastData(HistoryUtil.nphHabits.value).value);
        etMenarquia.setText(data.getLastData(HistoryUtil.nphMenarquia.value).value);
        etMenstrualCycle.setText(data.getLastData(HistoryUtil.nphMenstrualCycle.value).value);
        etLastMenstruation.setText(data.getLastData(HistoryUtil.nphLastMenstruation.value).value);
        etContraceptiveMethods.setText(data.getLastData(HistoryUtil.nphContraceptiveMethods.value).value);
        etGestation.setText(data.getLastData(HistoryUtil.nphGestations.value).value);
        etParturitions.setText(data.getLastData(HistoryUtil.nphParturitions.value).value);
        etLivingChildren.setText(data.getLastData(HistoryUtil.nphLivingChildren.value).value);
    }

    @Override
    public void saveInfo() {
        wizardViewModel.setNoPathologicalHistory(
            etPrenatalPeriod.getText().toString(),
            etNataPeriod.getText().toString(),
            etPosnatalPeriod.getText().toString(),
            etImmunizations.getText().toString(),
            etNutrition.getText().toString(),
            etHabits.getText().toString(),
            etMenarquia.getText().toString(),
            etMenstrualCycle.getText().toString(),
            etLastMenstruation.getText().toString(),
            etContraceptiveMethods.getText().toString(),
            etGestation.getText().toString(),
            etParturitions.getText().toString(),
            etLivingChildren.getText().toString()
        );
    }

    @Override
    public void initComponents(View view) {
        etPrenatalPeriod = view.findViewById(R.id.prenatalPeriod_EText);
        etNataPeriod = view.findViewById(R.id.nataPeriod_EText);
        etPosnatalPeriod = view.findViewById(R.id.posnatalPeriod_EText);
        etImmunizations = view.findViewById(R.id.immunizations_EText);
        etNutrition = view.findViewById(R.id.nutrition_EText);
        etHabits = view.findViewById(R.id.habits_EText);
        etMenarquia = view.findViewById(R.id.menarquia_EText);
        etMenstrualCycle = view.findViewById(R.id.menstrualCycle_EText);
        etLastMenstruation = view.findViewById(R.id.lastMenstruation_EText);
        etContraceptiveMethods = view.findViewById(R.id.contraceptiveMethods_EText);
        etGestation = view.findViewById(R.id.gestations_EText);
        etParturitions = view.findViewById(R.id.parturitions_EText);
        etLivingChildren = view.findViewById(R.id.livingChildren_EText);
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

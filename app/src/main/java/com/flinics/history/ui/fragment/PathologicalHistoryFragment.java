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
 * {@link PathologicalHistoryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PathologicalHistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PathologicalHistoryFragment extends Fragment implements IWizardAction {

    private WizardViewModel wizardViewModel;
    private OnFragmentInteractionListener mListener;

    // UI Elements
    protected EditText etFamiliars;
    protected EditText etMedicals;
    protected EditText etTraumatics;
    protected EditText etAllergics;
    protected EditText etGinecoObstetrics;
    protected EditText etViceAndManias;

    public PathologicalHistoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment PathologicalHistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PathologicalHistoryFragment newInstance() {
        PathologicalHistoryFragment fragment = new PathologicalHistoryFragment();
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
        View view =  inflater.inflate(R.layout.fragment_pathological_history, container, false);
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
        etFamiliars.setText(data.getLastData(HistoryUtil.phFamiliar.value).value);
        etMedicals.setText(data.getLastData(HistoryUtil.phMedical.value).value);
        etTraumatics.setText(data.getLastData(HistoryUtil.phTraumatic.value).value);
        etAllergics.setText(data.getLastData(HistoryUtil.phAllergic.value).value);
        etGinecoObstetrics.setText(data.getLastData(HistoryUtil.phGinecoObstetrics.value).value);
        etViceAndManias.setText(data.getLastData(HistoryUtil.phViceAndManias.value).value);
    }

    @Override
    public void saveInfo() {
        wizardViewModel.setPathologicalHistory(
                etFamiliars.getText().toString(),
                etMedicals.getText().toString(),
                etTraumatics.getText().toString(),
                etAllergics.getText().toString(),
                etGinecoObstetrics.getText().toString(),
                etViceAndManias.getText().toString()
        );
    }

    @Override
    public void initComponents(View view) {
        etFamiliars = view.findViewById(R.id.familiars_EText);
        etMedicals = view.findViewById(R.id.medicals_EText);
        etTraumatics = view.findViewById(R.id.traumatics_EText);
        etAllergics = view.findViewById(R.id.allergics_EText);
        etGinecoObstetrics = view.findViewById(R.id.ginecoObstetrics_EText);
        etViceAndManias = view.findViewById(R.id.viceAndManias_EText);
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

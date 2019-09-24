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
 * {@link ReasonConsultationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ReasonConsultationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReasonConsultationFragment extends Fragment implements IWizardAction {

    private WizardViewModel wizardViewModel;
    private OnFragmentInteractionListener mListener;

    // UI Elements
    protected EditText etConsultationReason;

    public ReasonConsultationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment ReasonConsultationFragment.
     */
    public static ReasonConsultationFragment newInstance() {
        ReasonConsultationFragment fragment = new ReasonConsultationFragment();
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
        View view =  inflater.inflate(R.layout.fragment_consultation_reason, container, false);
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
        etConsultationReason.setText(data.getLastData(HistoryUtil.consultationReason.value).value);
    }

    @Override
    public void saveInfo() {
        wizardViewModel.setConsultationReason(etConsultationReason.getText().toString());
    }

    @Override
    public void initComponents(View view) {
        etConsultationReason = view.findViewById(R.id.consultationReason_EText);
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

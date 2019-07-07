package com.flinics.history;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GeneralInfoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GeneralInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GeneralInfoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String _patient_name;
    private String _gender;
    private String _birthdate;
    private String _civil_status;
    private String _religion;
    private String _origin;
    private String _home;
    private String _profession;
    private String _occupation;
    private String _race;
    private String _ethnicity;
    private String _scholarship;
    private String _alphabet;
    private String _phone;
    private String _informant_name;

    private OnFragmentInteractionListener mListener;

    public GeneralInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param patient_name Patient Name.
     * @param gender Patient Gender.
     * @param birthdate Patient Birthdate.
     * @param civil_status Patient Civil Status.
     * @param religion Patient Religion.
     * @param origin Patient Origin.
     * @param home Patient Home.
     * @param profession Patient Profession.
     * @param occupation Patient Occupation.
     * @param gender Patient Gender.
     * @param race Patient Race.
     * @param ethnicity Patient Ethnicity.
     * @param scholarship Patient Scholarship.
     * @param alphabet Patient alphabet.
     * @param phone Patient phone.
     * @param informant_name Patient informant_name.
     * @return A new instance of fragment GeneralInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GeneralInfoFragment newInstance(
            String patient_name
            , String gender
            , String birthdate
            , String civil_status
            , String religion
            , String origin
            , String home
            , String profession
            , String occupation
            , String race
            , String ethnicity
            , String scholarship
            , String alphabet
            , String phone
            , String informant_name
    ) {
        GeneralInfoFragment fragment = new GeneralInfoFragment();
        Bundle args = new Bundle();
        // args.putString(ARG_PARAM1, param1);
        // args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // mParam1 = getArguments().getString(ARG_PARAM1);
            // mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_general_info, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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

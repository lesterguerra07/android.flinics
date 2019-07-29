package com.flinics.history.ui.fragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.flinics.history.R;

import java.util.Calendar;


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

    //Calendar to get date
    public final Calendar calendar = Calendar.getInstance();
    //date variables
    final int month = calendar.get(Calendar.MONTH);
    final int day = calendar.get(Calendar.DAY_OF_MONTH);
    final int year = calendar.get(Calendar.YEAR);
    private static final String _zero = "0";
    private static final String _slash = "/";

    Button btnDate;
    EditText etDate;

    // TODO: Rename and change types of parameters
    private String _general_info_data;

    private OnFragmentInteractionListener mListener;

    public GeneralInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param general_info_data General Information Data.
     * @return A new instance of fragment GeneralInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GeneralInfoFragment newInstance(
            String[] general_info_data
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
        View view =  inflater.inflate(R.layout.fragment_general_info, container, false);
        btnDate = (Button) view.findViewById(R.id.birthdate_Button);
        etDate = (EditText) view.findViewById(R.id.birthdate_EText);
        Log.d("FragmentTest", btnDate != null ? "IS NOT NULL" : "IS NULL");
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDate(getContext());
            }
        });
        return view;
    }

    public void getDate(Context context){
        DatePickerDialog pickDate = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                final int current_month = month + 1;
                String format_day = (dayOfMonth < 10)? _zero + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                String format_month = (current_month < 10)? _zero + String.valueOf(current_month):String.valueOf(current_month);
                etDate.setText(format_day + _slash + format_month + _slash + year);
                btnDate.setText(format_day + _slash + format_month + _slash + year);
            }
        },year, month, day);
        //show datepicker widget
        pickDate.show();
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

package com.flinics.history.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

import com.flinics.history.R;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AnthropometricMeasuresFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AnthropometricMeasuresFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnthropometricMeasuresFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_DATA = "data";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private HashMap<String, String> mdata;
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AnthropometricMeasuresFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @param data
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnthropometricMeasuresFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnthropometricMeasuresFragment newInstance(HashMap<String, String> data, String param1, String param2) {
        AnthropometricMeasuresFragment fragment = new AnthropometricMeasuresFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_DATA, data);
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mdata = (HashMap<String, String>) getArguments().getSerializable(ARG_DATA);
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anthropometric_measures, container, false);
    }

    @Override
    public void onPause() {
        super.onPause();

        storeEditTextValue(R.id.weight_EText, "weight");
        storeRadioGroupValue(R.id.weight_RGroup, "weightScale");
        storeEditTextValue(R.id.size_EText, "size");
        storeRadioGroupValue(R.id.size_RGroup, "sizeScale");
        storeEditTextValue(R.id.BMI_EText, "bmi");
        storeEditTextValue(R.id.cephalicCircumference_EText, "cephalicCircumference");
    }

    private void storeEditTextValue(final int viewId, final String key) {
        final EditText editText = getView().findViewById(viewId);
        mdata.put(key, editText.getText().toString());
    }

    private void storeRadioGroupValue(final int viewId, final String key) {
        final RadioGroup radioGroup = getView().findViewById(viewId);
        final int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();

        if (checkedRadioButtonId > 0) {
            final RadioButton radioButton = getView().findViewById(checkedRadioButtonId);
            mdata.put(key, radioButton.getText().toString());
        }
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

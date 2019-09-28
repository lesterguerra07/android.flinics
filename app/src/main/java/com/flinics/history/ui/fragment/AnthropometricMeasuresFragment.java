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
import android.widget.RadioButton;
import android.widget.RadioGroup;

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
 * {@link AnthropometricMeasuresFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AnthropometricMeasuresFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnthropometricMeasuresFragment extends Fragment implements IWizardAction {

    private WizardViewModel wizardViewModel;
    private OnFragmentInteractionListener mListener;

    // UI Elements
    protected EditText etWeight;
    protected EditText etSize;
    protected EditText etBMI;
    protected EditText etCephalicCircumference;
    protected RadioGroup rgWeight;
    protected RadioGroup rgSize;

    public AnthropometricMeasuresFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment AnthropometricMeasuresFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnthropometricMeasuresFragment newInstance() {
        AnthropometricMeasuresFragment fragment = new AnthropometricMeasuresFragment();
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
        View view =  inflater.inflate(R.layout.fragment_anthropometric_measures, container, false);
        initComponents(view);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        saveInfo();
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

    @Override
    public void displayInfo(ClinicHistoryModel data) {
        etWeight.setText(data.getLastData(HistoryUtil.amWeight.value).value);
        etSize.setText(data.getLastData(HistoryUtil.amSize.value).value);
        etCephalicCircumference.setText(data.getLastData(HistoryUtil.amCephalicCircumference.value).value);

        int selectedSize;
        if (data.getLastData(HistoryUtil.amSizeUnit.value).value.equals(this.getActivity().getResources().getString(R.string.centimeter))){
            selectedSize = R.id.centimeter_RButton;
        } else {
            selectedSize = R.id.meter_RButton;
        }
        rgSize.check(selectedSize);

        int selectedWeight;
        if (data.getLastData(HistoryUtil.amWeightUnit.value).value.equals(this.getActivity().getResources().getString(R.string.pound))){
            selectedWeight = R.id.pound_RButton;
        } else {
            selectedWeight = R.id.kilogram_RButton;
        }
        rgWeight.check(selectedWeight);
        etBMI.setText(data.getLastData(HistoryUtil.amImc.value).value);
    }

    @Override
    public void saveInfo() {
        String strWeightUnit = ((RadioButton) getActivity().findViewById(rgWeight.getCheckedRadioButtonId())).getText().toString();
        String strSizeUnit = ((RadioButton) getActivity().findViewById(rgSize.getCheckedRadioButtonId())).getText().toString();
        wizardViewModel.setAntropometricMeasures(
                etWeight.getText().toString(),
                strWeightUnit,
                etSize.getText().toString(),
                strSizeUnit,
                etBMI.getText().toString(),
                etCephalicCircumference.getText().toString()
        );
    }

    @Override
    public void initComponents(View view) {
        etWeight = view.findViewById(R.id.weight_EText);
        etSize = view.findViewById(R.id.size_EText);
        etCephalicCircumference = view.findViewById(R.id.cephalicCircumference_EText);
        etBMI = view.findViewById(R.id.BMI_EText);
        rgSize = view.findViewById(R.id.size_RGroup);
        rgWeight = view.findViewById(R.id.weight_RGroup);
        etWeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                etBMI.setText(getBMI());
            }
        });

        etSize.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                etBMI.setText(getBMI());
            }
        });

        rgSize.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                etBMI.setText(getBMI());
            }
        });

        rgWeight.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                etBMI.setText(getBMI());
            }
        });

        displayInfo(wizardViewModel.getClinicHistory());
    }

    public String getBMI(){
        //kg/(m^2)
        if(getActivity().findViewById(rgSize.getCheckedRadioButtonId()) == null || getActivity().findViewById(rgWeight.getCheckedRadioButtonId()) == null) return "0.00";
        double size;
        double weight;
        try {
            size = Double.parseDouble(etSize.getText().toString());
            weight = Double.parseDouble(etWeight.getText().toString());
        } catch (Exception e){
            return "0.00";
        }
        if (size == 0 || weight == 0) return "0.00";

        String strSizeUnit = ((RadioButton) getActivity().findViewById(rgSize.getCheckedRadioButtonId())).getText().toString();
        String strWeightUnit = ((RadioButton) getActivity().findViewById(rgWeight.getCheckedRadioButtonId())).getText().toString();

        if (strSizeUnit == this.getActivity().getResources().getString(R.string.centimeter)) {
            size = size / 100;
        }
        if (strWeightUnit == this.getActivity().getResources().getString(R.string.pound)){
            weight = weight / 2.20462262184878;
        }
        return String.format("%.2f", weight / (size*size));
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

package com.flinics.history.ui.fragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.flinics.history.R;
import com.flinics.history.data.model.ClinicHistoryModel;
import com.flinics.history.interfaces.IWizardAction;
import com.flinics.history.utils.HistoryUtil;
import com.flinics.history.utils.Util;
import com.flinics.history.view_model.WizardViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GeneralInfoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GeneralInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GeneralInfoFragment extends Fragment implements IWizardAction {
    private static final String ARG_DATA = "data";

    //Calendar to get date
    private final Calendar calendar = Calendar.getInstance();
    //date variables
    private final int month = calendar.get(Calendar.MONTH);
    private final int day = calendar.get(Calendar.DAY_OF_MONTH);
    private final int year = calendar.get(Calendar.YEAR);
    private static final String _zero = "0";
    private WizardViewModel wizardViewModel;

    private Button btnDate;
    private EditText etDate;

    private OnFragmentInteractionListener mListener;

    // UI Elements
    protected EditText etPatientName;
    protected ToggleButton tbGender;
    protected EditText etBirthdate;
    protected RadioGroup rgCivilStatus;
    protected EditText etReligion;
    protected EditText etOrigin;
    protected EditText etHome;
    protected EditText etProfession;
    protected EditText etOccupation;
    protected RadioGroup rgRace;
    protected RadioGroup rgEthnicity;
    protected EditText etScholarship;
    protected ToggleButton tbLiterate;
    protected EditText etPhone;
    protected EditText etInformantName;




    public GeneralInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment GeneralInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GeneralInfoFragment newInstance() {
        GeneralInfoFragment fragment = new GeneralInfoFragment();
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
        View view =  inflater.inflate(R.layout.fragment_general_info, container, false);
        initComponents(view);
        return view;
    }

    public void getDate(Context context){
        DatePickerDialog pickDate = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                final int current_month = month + 1;
                String format_day = (dayOfMonth < 10)? _zero + dayOfMonth : String.valueOf(dayOfMonth);
                String format_month = (current_month < 10)? _zero + current_month : String.valueOf(current_month);
                etDate.setText(getString(R.string.date_format, format_day, format_month, year));
                btnDate.setText(getString(R.string.date_format, format_day, format_month, year));
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

    @Override
    public  void initComponents(View view){
        btnDate = view.findViewById(R.id.birthdate_Button);
        etDate = view.findViewById(R.id.birthdate_EText);
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDate(getContext());
            }
        });
        etPatientName = view.findViewById(R.id.patientName_EText);
        tbGender = view.findViewById(R.id.gender_TButton);
        etBirthdate = view.findViewById(R.id.birthdate_EText);
        rgCivilStatus = view.findViewById(R.id.civilStatus_RGroup);
        etReligion = view.findViewById(R.id.religion_EText);
        etOrigin = view.findViewById(R.id.origin_EText);
        etHome = view.findViewById(R.id.home_EText);
        etProfession = view.findViewById(R.id.profession_EText);
        etOccupation = view.findViewById(R.id.occupation_EText);
        rgRace = view.findViewById(R.id.race_RGroup);
        rgEthnicity = view.findViewById(R.id.ethnicity_RGroup);
        etScholarship = view.findViewById(R.id.scholarship_EText);
        tbLiterate = view.findViewById(R.id.literate_TButton);
        etPhone = view.findViewById(R.id.phone_EText);
        etInformantName = view.findViewById(R.id.informantName_EText);

        displayInfo(wizardViewModel.getClinicHistory());
    }

    @Override
    public void displayInfo(ClinicHistoryModel data){
        etPatientName.setText(data.getLastData(HistoryUtil.giName.value).value);
        tbGender.setChecked(data.getLastData(HistoryUtil.giGender.value).value == this.getActivity().getResources().getString(R.string.male));
        etBirthdate.setText(data.getLastData(HistoryUtil.giBirthdate.value).value);
        int selectedCivilStatus;
        if (data.getLastData(HistoryUtil.giCivilStatus.value).value == this.getActivity().getResources().getString(R.string.single)){
            selectedCivilStatus = R.id.single_RButton;
        } else if (data.getLastData(HistoryUtil.giCivilStatus.value).value == this.getActivity().getResources().getString(R.string.married)){
            selectedCivilStatus = R.id.married_RButton;
        } else {
            selectedCivilStatus = R.id.lawfulUnion_RButton;
        }
        rgCivilStatus.check(selectedCivilStatus);
        etReligion.setText(data.getLastData(HistoryUtil.giReligion.value).value);
        etOrigin.setText(data.getLastData(HistoryUtil.giOrigin.value).value);
        etHome.setText(data.getLastData(HistoryUtil.giHome.value).value);
        etProfession.setText(data.getLastData(HistoryUtil.giProfession.value).value);
        etOccupation.setText(data.getLastData(HistoryUtil.giOccupation.value).value);
        int selectedRace;
        if (data.getLastData(HistoryUtil.giRace.value).value == this.getActivity().getResources().getString(R.string.white_race)){
            selectedRace = R.id.whiteRace_RButton;
        } else if (data.getLastData(HistoryUtil.giRace.value).value == this.getActivity().getResources().getString(R.string.black_race)){
            selectedRace = R.id.blackRace_RButton;
        } else if (data.getLastData(HistoryUtil.giRace.value).value == this.getActivity().getResources().getString(R.string.cooper_race)){
            selectedRace = R.id.cooperRace_RButton;
        } else {
            selectedRace = R.id.yellowRace_RButton;
        }
        rgRace.check(selectedRace);
        int selectedEthnicity;
        if (data.getLastData(HistoryUtil.giRace.value).value == this.getActivity().getResources().getString(R.string.no_native_ethnicity)){
            selectedEthnicity = R.id.noNative_RButton;
        } else {
            selectedEthnicity = R.id.native_RButton;
        }
        rgEthnicity.check(selectedEthnicity);
        etScholarship.setText(data.getLastData(HistoryUtil.giScholarship.value).value);
        tbLiterate.setChecked(data.getLastData(HistoryUtil.giLiterate.value).value == this.getActivity().getResources().getString(R.string.illiterate));
        etPhone.setText(data.getLastData(HistoryUtil.giPhone.value).value);
        etInformantName.setText(data.getLastData(HistoryUtil.giInformantName.value).value);
    }

    @Override
    public void saveInfo() {
        String strCivilStatus = ((RadioButton) getActivity().findViewById(rgCivilStatus.getCheckedRadioButtonId())).getText().toString();
        String strRace = ((RadioButton) getActivity().findViewById(rgRace.getCheckedRadioButtonId())).getText().toString();
        String strEthnicity = ((RadioButton) getActivity().findViewById(rgEthnicity.getCheckedRadioButtonId())).getText().toString();
        SimpleDateFormat birthdateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date birthdate = null;
        try {
            birthdate = birthdateFormat.parse(etBirthdate.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        wizardViewModel.setGeneralInformation(
                etPatientName.getText().toString()
                , (birthdate != null) ? Integer.toString(Util.getAge(birthdate)) : ""
                , etBirthdate.getText().toString()
                , tbGender.getText().toString()
                , strCivilStatus
                , etReligion.getText().toString()
                , etOrigin.getText().toString()
                , etHome.getText().toString()
                , etProfession.getText().toString()
                , etOccupation.getText().toString()
                , strRace
                , strEthnicity
                , etScholarship.getText().toString()
                , tbLiterate.getText().toString()
                , etPhone.getText().toString()
                , etInformantName.getText().toString()
        );
    }
}

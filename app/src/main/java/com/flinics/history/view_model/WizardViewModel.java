package com.flinics.history.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.flinics.history.data.model.ClinicHistoryModel;
import com.flinics.history.utils.HistoryUtil;

public class WizardViewModel extends AndroidViewModel {
    private String tag = this.getClass().getSimpleName();
    private String _id = "";
    private ClinicHistoryModel _data;
    private MutableLiveData<Integer> edad = new MutableLiveData<>();

    public WizardViewModel(@NonNull Application application) {
        super(application);
        _data = new ClinicHistoryModel();
    }

    public ClinicHistoryModel getClinicHistory(){
        return _data;
    }

    public  void setId(String id){
        _id = id;
    }

    public String getId(){
        return _id;
    }

    public void setClinicHistory(ClinicHistoryModel data){
        _data = data;
    }

    public MutableLiveData<Integer> getEdad(){
        return edad;
    }

    public void setEdad(int _edad){
        edad.setValue(_edad);
    }

    public void setGeneralInformation(
            String Name
            , String Age
            , String Birthdate
            , String Gender
            , String CivilStatus
            , String Religion
            , String Origin
            , String Home
            , String Profession
            , String Occupation
            , String Race
            , String Ethnicity
            , String Scholarship
            , String Literate
            , String Phone
            , String InformantName
    ){
        _data.setData(HistoryUtil.giName.value, Name);
        _data.setData(HistoryUtil.giAge.value, Age);
        _data.setData(HistoryUtil.giBirthdate.value, Birthdate);
        _data.setData(HistoryUtil.giGender.value, Gender);
        _data.setData(HistoryUtil.giCivilStatus.value, CivilStatus);
        _data.setData(HistoryUtil.giReligion.value, Religion);
        _data.setData(HistoryUtil.giOrigin.value, Origin);
        _data.setData(HistoryUtil.giHome.value, Home);
        _data.setData(HistoryUtil.giProfession.value, Profession);
        _data.setData(HistoryUtil.giOccupation.value, Occupation);
        _data.setData(HistoryUtil.giRace.value, Race);
        _data.setData(HistoryUtil.giEthnicity.value, Ethnicity);
        _data.setData(HistoryUtil.giScholarship.value, Scholarship);
        _data.setData(HistoryUtil.giLiterate.value, Literate);
        _data.setData(HistoryUtil.giPhone.value, Phone);
        _data.setData(HistoryUtil.giInformantName.value, InformantName);
    }

    public void setConsultationReason(String ConsultationReason){
        _data.setData(HistoryUtil.consultationReason.value, ConsultationReason);
    }

    public void setCurrentDiseaseHistory(String CurrentDiseaseHistory){
        _data.setData(HistoryUtil.currentDiseaseHistory.value, CurrentDiseaseHistory);
    }

    public void setPathologicalHistory(
            String Familiar
            , String Medical
            , String Traumatic
            , String Allergic
            , String GinecoObstetrics
            , String ViceAndManias
    ){
        _data.setData(HistoryUtil.phFamiliar.value, Familiar);
        _data.setData(HistoryUtil.phMedical.value, Medical);
        _data.setData(HistoryUtil.phTraumatic.value, Traumatic);
        _data.setData(HistoryUtil.phAllergic.value, Allergic);
        _data.setData(HistoryUtil.phGinecoObstetrics.value, GinecoObstetrics);
        _data.setData(HistoryUtil.phViceAndManias.value, ViceAndManias);
    }

    public void setNoPathologicalHistory(
            String PrenatalPeriod
            , String NataPeriod
            , String PostnatalPeriod
            , String Immunizations
            , String Nutrition
            , String Habits
            , String Menarquia
            , String MenstrualCycle
            , String LastMenstruation
            , String ContraceptiveMethods
            , String Gestations
            , String Parturitions
            , String LivingChildren
    ){
        _data.setData(HistoryUtil.nphPrenatalPeriod.value, PrenatalPeriod);
        _data.setData(HistoryUtil.nphNataPeriod.value, NataPeriod);
        _data.setData(HistoryUtil.nphPostnatalPeriod.value, PostnatalPeriod);
        _data.setData(HistoryUtil.nphImmunizations.value, Immunizations);
        _data.setData(HistoryUtil.nphNutrition.value, Nutrition);
        _data.setData(HistoryUtil.nphHabits.value, Habits);
        _data.setData(HistoryUtil.nphMenarquia.value, Menarquia);
        _data.setData(HistoryUtil.nphMenstrualCycle.value, MenstrualCycle);
        _data.setData(HistoryUtil.nphLastMenstruation.value, LastMenstruation);
        _data.setData(HistoryUtil.nphContraceptiveMethods.value, ContraceptiveMethods);
        _data.setData(HistoryUtil.nphGestations.value, Gestations);
        _data.setData(HistoryUtil.nphParturitions.value, Parturitions);
        _data.setData(HistoryUtil.nphLivingChildren.value, LivingChildren);
    }

    public void setSystemsReview(
            String Conduct
            , String SkinAndFaneras
            , String Head
            , String Eyes
            , String Nose
            , String Mouth
            , String Throat
            , String Neck
            , String MammaryLand
            , String LymphaticSystem
            , String RespiratorySystem
            , String CardiovascularSystem
            , String DigestiveSystem
            , String GenotourinarySystem
            , String EndocrineSystem
            , String SkeletalMuscleSystem
            , String NervousSystem
    ){
        _data.setData(HistoryUtil.srConduct.value, Conduct);
        _data.setData(HistoryUtil.srSkinAndFaneras.value, SkinAndFaneras);
        _data.setData(HistoryUtil.srHead.value, Head);
        _data.setData(HistoryUtil.srEyes.value, Eyes);
        _data.setData(HistoryUtil.srNose.value, Nose);
        _data.setData(HistoryUtil.srMouth.value, Mouth);
        _data.setData(HistoryUtil.srThroat.value, Throat);
        _data.setData(HistoryUtil.srNeck.value, Neck);
        _data.setData(HistoryUtil.srMammaryLand.value, MammaryLand);
        _data.setData(HistoryUtil.srLymphaticSystem.value, LymphaticSystem);
        _data.setData(HistoryUtil.srRespiratorySystem.value, RespiratorySystem);
        _data.setData(HistoryUtil.srCardiovascularSystem.value, CardiovascularSystem);
        _data.setData(HistoryUtil.srDigestiveSystem.value, DigestiveSystem);
        _data.setData(HistoryUtil.srGenotourinarySystem.value, GenotourinarySystem);
        _data.setData(HistoryUtil.srEndocrineSystem.value, EndocrineSystem);
        _data.setData(HistoryUtil.srSkeletalMuscleSystem.value, SkeletalMuscleSystem);
        _data.setData(HistoryUtil.srNervousSystem.value, NervousSystem);
    }

    public void setSocialProfile(String SocialProfile){
        _data.setData(HistoryUtil.socialProfile.value, SocialProfile);
    }

    public void setAntropometricMeasures(
            String Weight
            , String WeightUnit
            , String Size
            , String SizeUnit
            , String Imc
            , String CephalicCircumference
    ){
        _data.setData(HistoryUtil.amWeight.value, Weight);
        _data.setData(HistoryUtil.amWeightUnit.value, WeightUnit);
        _data.setData(HistoryUtil.amSize.value, Size);
        _data.setData(HistoryUtil.amSizeUnit.value, SizeUnit);
        _data.setData(HistoryUtil.amImc.value, Imc);
        _data.setData(HistoryUtil.amCephalicCircumference.value, CephalicCircumference);
    }

    public void setVitalSign(
            String Temperature
            , String BloodPressureLeft
            , String BloodPressureRight
            , String HeartRate
            , String PulseRate
            , String BreathingFrequency
    ){
        _data.setData(HistoryUtil.vsTemperature.value, Temperature);
        _data.setData(HistoryUtil.vsBloodPressureLeft.value, BloodPressureLeft);
        _data.setData(HistoryUtil.vsBloodPressureRight.value, BloodPressureRight);
        _data.setData(HistoryUtil.vsHeartRate.value, HeartRate);
        _data.setData(HistoryUtil.vsPulseRate.value, PulseRate);
        _data.setData(HistoryUtil.vsBreathingFrequency.value, BreathingFrequency);
    }

    public void setGeneralInspection(String GeneralInspection){
        _data.setData(HistoryUtil.generalInspection.value, GeneralInspection);
    }

    public void setOrganEvaluation(
            String SkinAndFaneras
            , String Head
            , String Eyes
            , String Ears
            , String Nose
            , String Oropharynx
            , String Neck
            , String Chest
            , String Abdomen
            , String LumbarRegion
            , String Extremities
            , String Neurological
    ){
        _data.setData(HistoryUtil.oeSkinAndFaneras.value, SkinAndFaneras);
        _data.setData(HistoryUtil.oeHead.value, Head);
        _data.setData(HistoryUtil.oeEyes.value, Eyes);
        _data.setData(HistoryUtil.oeEars.value, Ears);
        _data.setData(HistoryUtil.oeNose.value, Nose);
        _data.setData(HistoryUtil.oeOropharynx.value, Oropharynx);
        _data.setData(HistoryUtil.oeNeck.value, Neck);
        _data.setData(HistoryUtil.oeChest.value, Chest);
        _data.setData(HistoryUtil.oeAbdomen.value, Abdomen);
        _data.setData(HistoryUtil.oeLumbarRegion.value, LumbarRegion);
        _data.setData(HistoryUtil.oeExtremities.value, Extremities);
        _data.setData(HistoryUtil.oeNeurological.value, Neurological);
    }

}

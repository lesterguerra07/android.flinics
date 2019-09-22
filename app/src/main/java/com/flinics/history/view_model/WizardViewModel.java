package com.flinics.history.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.flinics.history.data.model.ClinicHistoryModel;
import com.flinics.history.utils.HistoryUtil;

public class WizardViewModel extends AndroidViewModel {
    private String tag = this.getClass().getSimpleName();
    private ClinicHistoryModel data;
    private MutableLiveData<Integer> edad = new MutableLiveData<>();

    public WizardViewModel(@NonNull Application application) {
        super(application);
        data = new ClinicHistoryModel();
    }

    public ClinicHistoryModel getClinicHistory(){
        return data;
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
        data.setData(HistoryUtil.giName.value, Name);
        data.setData(HistoryUtil.giAge.value, Age);
        data.setData(HistoryUtil.giBirthdate.value, Birthdate);
        data.setData(HistoryUtil.giGender.value, Gender);
        data.setData(HistoryUtil.giCivilStatus.value, CivilStatus);
        data.setData(HistoryUtil.giReligion.value, Religion);
        data.setData(HistoryUtil.giOrigin.value, Origin);
        data.setData(HistoryUtil.giHome.value, Home);
        data.setData(HistoryUtil.giProfession.value, Profession);
        data.setData(HistoryUtil.giOccupation.value, Occupation);
        data.setData(HistoryUtil.giRace.value, Race);
        data.setData(HistoryUtil.giEthnicity.value, Ethnicity);
        data.setData(HistoryUtil.giScholarship.value, Scholarship);
        data.setData(HistoryUtil.giLiterate.value, Literate);
        data.setData(HistoryUtil.giPhone.value, Phone);
        data.setData(HistoryUtil.giInformantName.value, InformantName);
    }

    public void setConsultationReason(String ConsultationReason){
        data.setData(HistoryUtil.consultationReason.value, ConsultationReason);
    }

    public void setCurrentDiseaseHistory(String CurrentDiseaseHistory){
        data.setData(HistoryUtil.currentDiseaseHistory.value, CurrentDiseaseHistory);
    }

    public void setPathologicalHistory(
            String Familiar
            , String Medical
            , String Traumatic
            , String Allergic
            , String GinecoObstetrics
            , String ViceAndManias
    ){
        data.setData(HistoryUtil.phFamiliar.value, Familiar);
        data.setData(HistoryUtil.phMedical.value, Medical);
        data.setData(HistoryUtil.phTraumatic.value, Traumatic);
        data.setData(HistoryUtil.phAllergic.value, Allergic);
        data.setData(HistoryUtil.phGinecoObstetrics.value, GinecoObstetrics);
        data.setData(HistoryUtil.phViceAndManias.value, ViceAndManias);
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
        data.setData(HistoryUtil.nphPrenatalPeriod.value, PrenatalPeriod);
        data.setData(HistoryUtil.nphNataPeriod.value, NataPeriod);
        data.setData(HistoryUtil.nphPostnatalPeriod.value, PostnatalPeriod);
        data.setData(HistoryUtil.nphImmunizations.value, Immunizations);
        data.setData(HistoryUtil.nphNutrition.value, Nutrition);
        data.setData(HistoryUtil.nphHabits.value, Habits);
        data.setData(HistoryUtil.nphMenarquia.value, Menarquia);
        data.setData(HistoryUtil.nphMenstrualCycle.value, MenstrualCycle);
        data.setData(HistoryUtil.nphLastMenstruation.value, LastMenstruation);
        data.setData(HistoryUtil.nphContraceptiveMethods.value, ContraceptiveMethods);
        data.setData(HistoryUtil.nphGestations.value, Gestations);
        data.setData(HistoryUtil.nphParturitions.value, Parturitions);
        data.setData(HistoryUtil.nphLivingChildren.value, LivingChildren);
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
        data.setData(HistoryUtil.srConduct.value, Conduct);
        data.setData(HistoryUtil.srSkinAndFaneras.value, SkinAndFaneras);
        data.setData(HistoryUtil.srHead.value, Head);
        data.setData(HistoryUtil.srEyes.value, Eyes);
        data.setData(HistoryUtil.srNose.value, Nose);
        data.setData(HistoryUtil.srMouth.value, Mouth);
        data.setData(HistoryUtil.srThroat.value, Throat);
        data.setData(HistoryUtil.srNeck.value, Neck);
        data.setData(HistoryUtil.srMammaryLand.value, MammaryLand);
        data.setData(HistoryUtil.srLymphaticSystem.value, LymphaticSystem);
        data.setData(HistoryUtil.srRespiratorySystem.value, RespiratorySystem);
        data.setData(HistoryUtil.srCardiovascularSystem.value, CardiovascularSystem);
        data.setData(HistoryUtil.srDigestiveSystem.value, DigestiveSystem);
        data.setData(HistoryUtil.srGenotourinarySystem.value, GenotourinarySystem);
        data.setData(HistoryUtil.srEndocrineSystem.value, EndocrineSystem);
        data.setData(HistoryUtil.srSkeletalMuscleSystem.value, SkeletalMuscleSystem);
        data.setData(HistoryUtil.srNervousSystem.value, NervousSystem);
    }

    public void setSocialProfile(String SocialProfile){
        data.setData(HistoryUtil.socialProfile.value, SocialProfile);
    }

    public void setAntropometricMeasures(
            String Weight
            , String WeightUnit
            , String Size
            , String SizeUnit
            , String Imc
            , String CephalicCircumference
    ){
        data.setData(HistoryUtil.amWeight.value, Weight);
        data.setData(HistoryUtil.amWeightUnit.value, WeightUnit);
        data.setData(HistoryUtil.amSize.value, Size);
        data.setData(HistoryUtil.amSizeUnit.value, SizeUnit);
        data.setData(HistoryUtil.amImc.value, Imc);
        data.setData(HistoryUtil.amCephalicCircumference.value, CephalicCircumference);
    }

    public void setVitalSign(
            String Temperature
            , String BloodPressureLeft
            , String BloodPressureRight
            , String HeartRate
            , String PulseRate
            , String BreathingFrequency
    ){
        data.setData(HistoryUtil.vsTemperature.value, Temperature);
        data.setData(HistoryUtil.vsBloodPressureLeft.value, BloodPressureLeft);
        data.setData(HistoryUtil.vsBloodPressureRight.value, BloodPressureRight);
        data.setData(HistoryUtil.vsHeartRate.value, HeartRate);
        data.setData(HistoryUtil.vsPulseRate.value, PulseRate);
        data.setData(HistoryUtil.vsBreathingFrequency.value, BreathingFrequency);
    }

    public void setGeneralInspection(String GeneralInspection){
        data.setData(HistoryUtil.generalInspection.value, GeneralInspection);
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
        data.setData(HistoryUtil.oeSkinAndFaneras.value, SkinAndFaneras);
        data.setData(HistoryUtil.oeHead.value, Head);
        data.setData(HistoryUtil.oeEyes.value, Eyes);
        data.setData(HistoryUtil.oeEars.value, Ears);
        data.setData(HistoryUtil.oeNose.value, Nose);
        data.setData(HistoryUtil.oeOropharynx.value, Oropharynx);
        data.setData(HistoryUtil.oeNeck.value, Neck);
        data.setData(HistoryUtil.oeChest.value, Chest);
        data.setData(HistoryUtil.oeAbdomen.value, Abdomen);
        data.setData(HistoryUtil.oeLumbarRegion.value, LumbarRegion);
        data.setData(HistoryUtil.oeExtremities.value, Extremities);
        data.setData(HistoryUtil.oeNeurological.value, Neurological);
    }

}

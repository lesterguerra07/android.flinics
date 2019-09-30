package com.flinics.history.data.model;

import com.flinics.history.utils.HistoryUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClinicHistoryModel {
    private HashMap<String, ArrayList<FieldModel>> _ClinicHistory;

    public ClinicHistoryModel(HashMap<String, ArrayList<FieldModel>> ClinicHistory){
        _ClinicHistory = ClinicHistory;
    }

    public ClinicHistoryModel() {
        _ClinicHistory = new HashMap<>();
        // GENERAL INFORMATION
        _ClinicHistory.put(HistoryUtil.giName.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.giAge.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.giBirthdate.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.giGender.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.giCivilStatus.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.giReligion.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.giOrigin.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.giHome.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.giProfession.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.giOccupation.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.giRace.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.giEthnicity.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.giScholarship.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.giLiterate.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.giPhone.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.giInformantName.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        // CONSULTATION REASON
        _ClinicHistory.put(HistoryUtil.consultationReason.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        // CURRENT DISEASE HISTORY
        _ClinicHistory.put(HistoryUtil.currentDiseaseHistory.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        // PATHOLOGICAL HISTORY
        _ClinicHistory.put(HistoryUtil.phFamiliar.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.phMedical.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.phTraumatic.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.phAllergic.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.phGinecoObstetrics.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.phViceAndManias.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        // NO PATHILOGICAL HISTORY
        _ClinicHistory.put(HistoryUtil.nphPrenatalPeriod.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.nphNataPeriod.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.nphPostnatalPeriod.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.nphImmunizations.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.nphNutrition.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.nphHabits.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.nphMenarquia.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.nphMenstrualCycle.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.nphLastMenstruation.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.nphContraceptiveMethods.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.nphGestations.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.nphParturitions.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.nphLivingChildren.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        // SYSTEMS REVIEW
        _ClinicHistory.put(HistoryUtil.srConduct.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.srSkinAndFaneras.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.srHead.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.srEyes.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.srNose.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.srMouth.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.srThroat.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.srNeck.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.srMammaryLand.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.srLymphaticSystem.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.srRespiratorySystem.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.srCardiovascularSystem.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.srDigestiveSystem.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.srGenotourinarySystem.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.srEndocrineSystem.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.srSkeletalMuscleSystem.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.srNervousSystem.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        // SOCIAL PROFILE
        _ClinicHistory.put(HistoryUtil.socialProfile.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        // ANTROPOMETRIC MEASURES
        _ClinicHistory.put(HistoryUtil.amWeight.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.amWeightUnit.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.amSize.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.amSizeUnit.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.amImc.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.amCephalicCircumference.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        // VITAL SIGN
        _ClinicHistory.put(HistoryUtil.vsTemperature.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.vsBloodPressureLeft.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.vsBloodPressureRight.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.vsHeartRate.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.vsPulseRate.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.vsBreathingFrequency.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        // GENERAL INSPECTION
        _ClinicHistory.put(HistoryUtil.generalInspection.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        // ORGAN EVALUATION
        _ClinicHistory.put(HistoryUtil.oeSkinAndFaneras.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.oeHead.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.oeEyes.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.oeEars.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.oeNose.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.oeOropharynx.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.oeNeck.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.oeChest.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.oeAbdomen.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.oeLumbarRegion.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.oeExtremities.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
        _ClinicHistory.put(HistoryUtil.oeNeurological.value, new ArrayList<FieldModel>(){{
            add(new FieldModel("", 0));
        }});
    }

    public HashMap<String, ArrayList<FieldModel>> getClinicHistory(){
        return _ClinicHistory;
    }

    public JSONObject toJSONObject() {
        try {
            JSONObject jsonObject = new JSONObject();
            for (Map.Entry<String , ArrayList<FieldModel>> entry : _ClinicHistory.entrySet()) {
                // Log.d("DATA","key=" + entry.getKey() + ", value=" + entry.getValue());
                JSONArray jsonArray = new JSONArray();
                for (FieldModel field : entry.getValue()){

                        jsonArray.put(new JSONObject()
                                .put("value",field.value)
                                .put("version", field.version));

                }
                jsonObject.put(entry.getKey(), jsonArray);
            }
            return jsonObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public ArrayList<FieldModel> getData(String field){
        return _ClinicHistory.get(field);
    }

    public FieldModel getData(String field, int version){
        ArrayList<FieldModel> fieldsModel = _ClinicHistory.get(field);

        if (fieldsModel == null) return null;

        if (fieldsModel.size() > version) return null;

        return fieldsModel.get(version - 1);
    }

    public FieldModel getFirstData(String field){
        ArrayList<FieldModel> fieldsModel = _ClinicHistory.get(field);
        if (fieldsModel == null) return null;
        return  fieldsModel.get(0);
    }

    public FieldModel getLastData(String field){
        ArrayList<FieldModel> fieldsModel = _ClinicHistory.get(field);
        if (fieldsModel == null || fieldsModel.size() == 0) return new FieldModel("", 0);
        return  fieldsModel.get(fieldsModel.size() - 1);
    }

    public void setNewData(String field, String value){
        ArrayList<FieldModel> fieldsModel = getData(field);

        if (fieldsModel == null) return;

        int newVersion = fieldsModel.size() + 1;

        FieldModel fieldModel = new FieldModel(value, newVersion);

        fieldsModel.add(fieldModel);
    }

    public void setData(String field, String value){
        ArrayList<FieldModel> fieldsModel = getData(field);

        if (fieldsModel == null) return;

        fieldsModel.get(0).value = value;
    }

    public static class FieldModel{
        public String _id;
        public int version;
        public String value;

        public  FieldModel(String _value, int _version){
            value = _value;
            version = _version;
        }
    }
}
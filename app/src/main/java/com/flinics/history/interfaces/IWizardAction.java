package com.flinics.history.interfaces;

import com.flinics.history.data.model.ClinicHistoryModel;
import android.view.View;

public interface IWizardAction {
    void displayInfo(ClinicHistoryModel data);
    void saveInfo();
    void initComponents(View view);
}

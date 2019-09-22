package com.flinics.history.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.flinics.history.R;
import com.flinics.history.ui.fragment.AnthropometricMeasuresFragment;
import com.flinics.history.ui.fragment.CurrentDiseaseHistoryFragment;
import com.flinics.history.ui.fragment.GeneralInfoFragment;
import com.flinics.history.ui.fragment.GeneralInspectionFragment;
import com.flinics.history.ui.fragment.NoPathologicalHistoryFragment;
import com.flinics.history.ui.fragment.OrganEvaluationFragment;
import com.flinics.history.ui.fragment.PathologicalHistoryFragment;
import com.flinics.history.ui.fragment.ReasonConsultationFragment;
import com.flinics.history.ui.fragment.SocialProfileFragment;
import com.flinics.history.ui.fragment.SystemsReviewFragment;
import com.flinics.history.ui.fragment.VitalSignsFragment;

import java.util.HashMap;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] _tab_titles = new int[]{
            R.string.tab_general_info
            , R.string.tab_consultation_reason
            , R.string.tab_history_current_disease
            , R.string.tab_pathological_history
            , R.string.tab_no_pathological_history
            , R.string.tab_systems_review
            , R.string.tab_social_profile
            , R.string.tab_anthropometric_measures
            , R.string.tab_vital_signs
            , R.string.tab_general_inspection
            , R.string.tab_organ_evaluation
    };
    private final Context mContext;
    private HashMap<String, String> data;

    public SectionsPagerAdapter(Context context, FragmentManager fm, HashMap<String, String> data) {
        super(fm);
        mContext = context;
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        switch (position){
            case 1:
                return ReasonConsultationFragment.newInstance(data, "", "");
            case 2:
                return CurrentDiseaseHistoryFragment.newInstance(data, "", "");
            case 3:
                return PathologicalHistoryFragment.newInstance(data, "", "");
            case 4:
                return NoPathologicalHistoryFragment.newInstance(data, "", "");
            case 5:
                return SystemsReviewFragment.newInstance(data, "", "");
            case 6:
                return SocialProfileFragment.newInstance(data, "", "");
            case 7:
                return AnthropometricMeasuresFragment.newInstance(data, "", "");
            case 8:
                return VitalSignsFragment.newInstance(data, "", "");
            case 9:
                return GeneralInspectionFragment.newInstance(data, "", "");
            case 10:
                return OrganEvaluationFragment.newInstance(data, "", "");
            default:
                return GeneralInfoFragment.newInstance();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(_tab_titles[position]);
    }

    @Override
    public int getCount() {
        return _tab_titles.length;
    }
}
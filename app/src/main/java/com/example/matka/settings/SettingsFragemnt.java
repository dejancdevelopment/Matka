package com.example.matka.settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreference;

import com.example.matka.R;

public class SettingsFragemnt extends PreferenceFragmentCompat {

    public SettingsFragemnt() {
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

        setPreferencesFromResource(R.xml.settings_prefereces,rootKey);

        SwitchPreference lang_pref=getPreferenceManager().findPreference("key_lang");
        lang_pref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {

                getActivity().recreate();
                return true;
            }
        });
    }


}

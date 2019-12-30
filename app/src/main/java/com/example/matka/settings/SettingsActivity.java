package com.example.matka.settings;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceManager;

import com.example.matka.R;

import java.util.Locale;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        Toolbar toolbar=findViewById(R.id.toolbar_settings);
        toolbar.setTitle(getString(R.string.settings_main));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTheme(R.style.SettingsFragmentStyle);

        FrameLayout frameLayout = findViewById(R.id.fragment_settings);

        if (frameLayout != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_settings, new SettingsFragemnt())
                    .commit();
        }

        setUpLanguage();
    }

    private void setUpLanguage() {
        Resources res = getBaseContext().getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        boolean lang_boolean= PreferenceManager.getDefaultSharedPreferences(this).getBoolean("key_lang", false);
        String lang=(lang_boolean)?"mk":"en";
        conf.setLocale(new Locale(lang.toLowerCase()));
        res.updateConfiguration(conf, dm);
    }
}

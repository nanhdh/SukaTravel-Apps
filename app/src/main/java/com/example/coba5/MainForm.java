package com.example.coba5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

public class MainForm extends AppCompatActivity {
    CardView MnBerbagi,MnBooking,MnLogout;
    private View parentView;
    Switch temaSwitch;

   UserSetting settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_form);
        MnBooking = findViewById(R.id.menu1);
        MnBerbagi = findViewById(R.id.menu2);
        MnLogout = findViewById(R.id.menu3);
        temaSwitch = findViewById(R.id.sTheme);
        parentView = findViewById(R.id.parentView);
        settings = (UserSetting) getApplication();
        loadSharedPreferences();
        initSwitchListener();

        MnBooking.setOnClickListener(view -> {
            Intent i2 = new Intent(MainForm.this, ListViewWisata.class);
            String email = getIntent().getStringExtra("PembuatInformasiWisata");
            i2.putExtra("PembuatInformasiWisata", email);
            startActivity(i2);
        });
        MnBerbagi.setOnClickListener(view -> {
            Intent i2 = new Intent(MainForm.this, AddInformasi.class);
            startActivity(i2);
        });
        MnLogout.setOnClickListener(view -> {
            Intent i2 = new Intent(MainForm.this, MainActivity.class);
            startActivity(i2);
            finish();
        });
    }

    private void initSwitchListener() {
        SharedPreferences sharedPreferences = getSharedPreferences(UserSetting.PREFERENCES, MODE_PRIVATE);
        String tema =sharedPreferences.getString(UserSetting.CUSTOM_THEME, UserSetting.KUNING_THEME);
        settings.setCustomTheme(tema);
    }
    private void loadSharedPreferences() {
        temaSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean periksa) {
                if (periksa)
                    settings.setCustomTheme(UserSetting.PUTIH_THEME);
                else
                    settings.setCustomTheme(UserSetting.KUNING_THEME);
            SharedPreferences.Editor okeEdit = getSharedPreferences(UserSetting.PREFERENCES,MODE_PRIVATE).edit();
            okeEdit.putString(UserSetting.CUSTOM_THEME, settings.getCustomTheme());
            okeEdit.apply();
            updateView();
            }
        });
    }

    private void updateView() {
        final int putih = ContextCompat.getColor(this, R.color.white);
        final int kuning = ContextCompat.getColor(this, R.color.background);

        if(settings.getCustomTheme().equals(UserSetting.PUTIH_THEME))
        {
            parentView.setBackgroundColor(putih);
            temaSwitch.setChecked(true);
        }
        else{
            parentView.setBackgroundColor(kuning);
            temaSwitch.setChecked(false);
        }
    }
}
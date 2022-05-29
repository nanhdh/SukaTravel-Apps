package com.example.coba5;

import android.app.Application;

public class UserSetting extends Application {
    public static final String PREFERENCES ="preferences";

    public static final String CUSTOM_THEME ="CustomTheme";
    public static final String KUNING_THEME ="KuningTheme";
    public static final String PUTIH_THEME="PutihTheme";

    private String CustomTheme;

    public String getCustomTheme() {
        return CustomTheme;
    }

    public void setCustomTheme(String customTheme) {
        CustomTheme = customTheme;
    }
}

package com.vatish.multitheme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    private ThemeHelper themeHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        themeHelper = new ThemeHelper(getSharedPreferences(ThemeConstants.PREF_KEY, MODE_PRIVATE));
        applyTheme();
    }

    private void applyTheme() {
        int lightTheme = R.style.LightTheme;
        int darkTheme = R.style.DarkTheme;
        setTheme(themeHelper.isLightTheme() ? lightTheme : darkTheme);
    }

    protected void changeTheme() {
        if (themeHelper.isLightTheme()) {
            themeHelper.setDarkTheme();
        } else {
            themeHelper.setLightTheme();
        }
        recreate();
    }
}

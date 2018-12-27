package com.vatish.multitheme;

import android.content.SharedPreferences;

import static com.vatish.multitheme.ThemeConstants.PREF_KEY;
import static com.vatish.multitheme.ThemeConstants.THEME_DARK;
import static com.vatish.multitheme.ThemeConstants.THEME_LIGHT;

class ThemeHelper {

    private SharedPreferences preferences;

    ThemeHelper(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    private String getTheme() {
        return preferences.getString(PREF_KEY, THEME_LIGHT);
    }

    private void setTheme(String theme) {
        preferences.edit()
                .putString(PREF_KEY, theme)
                .apply();
    }

    boolean isLightTheme() {
        return getTheme().equals(THEME_LIGHT);
    }

    void setLightTheme() {
        setTheme(THEME_LIGHT);
    }

    void setDarkTheme() {
        setTheme(THEME_DARK);
    }
}

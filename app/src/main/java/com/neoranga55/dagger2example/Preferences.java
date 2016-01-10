package com.neoranga55.dagger2example;

import android.content.SharedPreferences;
import android.util.Log;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Preferences {

    private final SharedPreferences mPreferences;

    private static final String TAG = "Preferences";
    public static final String FIRST_START_PREFERENCE = "First Application Started";

    @Inject
    public Preferences(SharedPreferences prefs) {
        mPreferences = prefs;
    }

    public void log(final String preference, final boolean value) {
        SharedPreferences.Editor edit = mPreferences.edit();
        edit.putBoolean(preference, value);
        edit.apply();
    }

    public void list() {
        Log.v(TAG, "Logging all preferences:");

        for (Map.Entry entry : mPreferences.getAll().entrySet())
            Log.v(getClass().getSimpleName(), entry.getKey() + " = " + entry.getValue());
    }
}

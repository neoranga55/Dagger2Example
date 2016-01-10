package com.neoranga55.dagger2example;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.neoranga55.dagger2example.dependency.injection.ActivityModule;
import com.neoranga55.dagger2example.dependency.injection.ApplicationComponent;

import java.util.Map;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
//    @Inject Preferences preferences;
    @Inject SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getApplicationComponent().inject(this);

//        preferences.log(Preferences.FIRST_START_PREFERENCE, true);
//        preferences.list();
//        (new Preferences()).list();
        for (Map.Entry entry : mPreferences.getAll().entrySet())
            Log.v(getClass().getSimpleName(), entry.getKey() + " = " + entry.getValue());
        Log.w(TAG, "Executed until the new end");
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((MyApplication)getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}

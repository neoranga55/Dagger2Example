package com.neoranga55.dagger2example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.neoranga55.dagger2example.dependency.injection.ActivityModule;
import com.neoranga55.dagger2example.dependency.injection.ApplicationComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Inject Preferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getApplicationComponent().inject(this);

        mPreferences.log(Preferences.FIRST_START_PREFERENCE, true);
        mPreferences.list();
        Log.v(TAG, "Executed until the end of Activity's onCreate");
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((MyApplication)getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}

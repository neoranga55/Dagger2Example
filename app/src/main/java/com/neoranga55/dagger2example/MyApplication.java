package com.neoranga55.dagger2example;

import android.app.Application;
import android.util.Log;

import com.neoranga55.dagger2example.dependency.injection.ApplicationComponent;
import com.neoranga55.dagger2example.dependency.injection.ApplicationModule;
import com.neoranga55.dagger2example.dependency.injection.DaggerApplicationComponent;

public class MyApplication extends Application {

    private static final String TAG = "MyApplication";

    private static ApplicationComponent mApplicationComponent;

    @Override public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this.getApplicationContext()))
                .build();
        Log.v(TAG, "Requesting SharedPreferences for the first time");
        final Preferences preferences = mApplicationComponent.preferences();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}

package com.neoranga55.dagger2example;

import android.app.Application;

import com.neoranga55.dagger2example.dependency.injection.ApplicationComponent;
import com.neoranga55.dagger2example.dependency.injection.ApplicationModule;
import com.neoranga55.dagger2example.dependency.injection.DaggerApplicationComponent;

public class MyApplication extends Application {
    private static ApplicationComponent mApplicationComponent;

    @Override public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
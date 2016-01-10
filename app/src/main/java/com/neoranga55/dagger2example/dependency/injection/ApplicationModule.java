package com.neoranga55.dagger2example.dependency.injection;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.neoranga55.dagger2example.MyApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final MyApplication mApplication;

    public ApplicationModule(final MyApplication application) {
        mApplication = application;
    }

    @Provides @Singleton public Context provideApplicationContext() {
        return mApplication.getApplicationContext();
    }

    @Singleton @Provides SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(mApplication.getApplicationContext());
//        final String PREFERENCES_NAME = "PREFERENCES_NAME";
//        return mApplication.getApplicationContext().getSharedPreferences(PREFERENCES_NAME, Context.MODE_ENABLE_WRITE_AHEAD_LOGGING);
    }

//    @Singleton @Provides Preferences providePreferences() {
//        return new Preferences();
//    }
}

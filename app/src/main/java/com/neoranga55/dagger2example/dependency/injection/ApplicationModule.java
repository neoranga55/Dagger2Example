package com.neoranga55.dagger2example.dependency.injection;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Context mAppContext;

    public ApplicationModule(final Context context) {
        mAppContext = context.getApplicationContext();
    }

    @Singleton @Provides
    Context provideApplicationContext() {
        return mAppContext;
    }

    @Singleton @Provides
    SharedPreferences provideSharedPreferences(final Context context) {
        Log.v("ApplicationModule", "Generating SharedPreferences for the first time");
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}

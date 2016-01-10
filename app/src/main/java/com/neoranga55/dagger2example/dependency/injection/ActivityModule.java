package com.neoranga55.dagger2example.dependency.injection;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private final Activity mActivity;

    public ActivityModule(final Activity activity) {
        mActivity = activity;
    }

    @Provides @PerActivity Activity activity() {
        return mActivity;
    }
}
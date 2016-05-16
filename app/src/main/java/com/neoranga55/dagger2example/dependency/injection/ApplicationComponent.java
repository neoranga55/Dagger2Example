package com.neoranga55.dagger2example.dependency.injection;

import android.content.Context;
import android.content.SharedPreferences;

import com.neoranga55.dagger2example.MainActivity;
import com.neoranga55.dagger2example.Preferences;

import javax.inject.Singleton;

import dagger.Component;

@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void injectActivity(MainActivity activity);

    //Exposed to sub-graphs.
//    Context context();
//    SharedPreferences sharedPreferences();
    Preferences preferences();
}

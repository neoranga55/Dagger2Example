package com.neoranga55.dagger2example.dependency.injection;

import com.neoranga55.repository.Preferences;

import javax.inject.Singleton;

import dagger.Component;

@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
//    void inject(MainActivity activity);

    //Exposed to sub-graphs.
//    Context context();
//    SharedPreferences sharedPreferences();
    Preferences preferences();
}

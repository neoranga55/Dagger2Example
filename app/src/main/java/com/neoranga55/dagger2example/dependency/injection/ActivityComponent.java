package com.neoranga55.dagger2example.dependency.injection;

import com.neoranga55.dagger2example.MainActivity;
import com.neoranga55.dagger2example.SecondActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = {ApplicationComponent.class}, modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(MainActivity activity);
    void inject(SecondActivity activity);
}

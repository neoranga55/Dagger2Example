package com.neoranga55.dagger2example.dependency.injection;

import com.neoranga55.repository.BigObject;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    @Provides @PerActivity
    BigObject provideBigObject() {
        return new BigObject();
    }
}

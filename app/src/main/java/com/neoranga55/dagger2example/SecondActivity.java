package com.neoranga55.dagger2example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.neoranga55.dagger2example.dependency.injection.ActivityComponent;
import com.neoranga55.dagger2example.dependency.injection.ActivityModule;
import com.neoranga55.dagger2example.dependency.injection.ApplicationComponent;
import com.neoranga55.dagger2example.dependency.injection.DaggerActivityComponent;
import com.neoranga55.repository.BigObject;
import com.neoranga55.repository.Preferences;

import javax.inject.Inject;

public class SecondActivity extends AppCompatActivity {

    @Inject
    Preferences mPreferences;
    @Inject
    BigObject mBigObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getActivityComponent().inject(this);
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((MyApplication)getApplication()).getApplicationComponent();
    }

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                        .applicationComponent(getApplicationComponent())
                        .activityModule(new ActivityModule())
                        .build();
    }

}

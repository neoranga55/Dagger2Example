package com.neoranga55.dagger2example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.neoranga55.dagger2example.dependency.injection.ActivityComponent;
import com.neoranga55.dagger2example.dependency.injection.ActivityModule;
import com.neoranga55.dagger2example.dependency.injection.ApplicationComponent;
import com.neoranga55.dagger2example.dependency.injection.DaggerActivityComponent;
import com.neoranga55.repository.BigObject;
import com.neoranga55.repository.Preferences;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Inject
    Preferences mPreferences;
    @Inject
    BigObject mBigObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        Log.v(TAG, "Requesting SharedPreferences for the second time");
        mPreferences.store(Preferences.FIRST_START_PREFERENCE, true);
        int size = mPreferences.list();
        Log.v(TAG, "Executed until the end of Activity's onCreate");
        TextView textView = (TextView) findViewById(R.id.tv_text);
        textView.setText(textView.getText() + " - Amount of preferences stored: " + size);
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

    public void mClickListener(View v) {
        switch (v.getId()) {
            case R.id.button:
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                break;
            default:
                break;
        }
    }
}

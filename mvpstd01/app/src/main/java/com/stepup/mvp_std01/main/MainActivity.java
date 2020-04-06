package com.stepup.mvp_std01.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.stepup.mvp_std01.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new MainFragment()).commit();

    }
}

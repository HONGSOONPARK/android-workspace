package com.stepup.baseproject.view.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.stepup.baseproject.R;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter();
        presenter.setView(this);
        presenter.loadItems(getApplicationContext(), false);


    }
}

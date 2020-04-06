package com.stepup.baseproject.view.main;

import android.content.Context;

import com.stepup.baseproject.model.MainModel;

public class MainPresenter implements MainContract.Presenter {

    MainContract.View view;
    MainModel mainModel;

    public MainPresenter(MainContract.View view){
        // View 연결
        view = view;

        // Model 연결
        mainModel = new MainModel(this);
    }

    @Override
    public void setView(MainContract.View view) {
        this.view =view;
    }

    @Override
    public void loadItems(Context context, boolean isClear) {

    }

    @Override
    public void addNums(int input1, int input2) {
        view.showResult(3);
    }

    @Override
    public void saveData(int data) {
        mainModel.saveData(data);
    }
}

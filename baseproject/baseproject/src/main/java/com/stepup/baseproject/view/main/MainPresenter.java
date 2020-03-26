package com.stepup.baseproject.view.main;

import android.content.Context;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view = null;

    @Override
    public void setView(MainContract.View view) {
        this.view =view;
    }

    @Override
    public void loadItems(Context context, boolean isClear) {

    }
}

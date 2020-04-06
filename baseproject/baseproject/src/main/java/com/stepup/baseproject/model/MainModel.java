package com.stepup.baseproject.model;

import com.stepup.baseproject.view.main.MainContract;

public class MainModel {

    MainContract.Presenter presenter;
    public MainModel(MainContract.Presenter presenter){
        this.presenter = presenter;
    }

    // Presenter 에서 데이터 저장 시 호출됩니다
    // 자세한 저장 로직은 생략했습니다
    public void saveData(int data){
        //Todo..SaveData
    }

}

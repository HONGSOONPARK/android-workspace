package com.stepup.baseproject.view.main;

import android.content.Context;

public interface MainContract {

    interface View{
        void showResult(int result);
    }

    interface Presenter {
        void setView(View view);
        void loadItems(Context context, boolean isClear);

        void addNums(int input1, int input2);
        void saveData(int data);

    }
}

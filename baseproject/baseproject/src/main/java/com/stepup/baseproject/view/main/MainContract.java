package com.stepup.baseproject.view.main;

import android.content.Context;

public interface MainContract {

    interface View{

    }


    interface Presenter {
        void setView(View view);

        void loadItems(Context context, boolean isClear);
    }
}

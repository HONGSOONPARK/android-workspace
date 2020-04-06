package com.stepup.baseproject.view.main;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.stepup.baseproject.R;

public class MainActivity extends Activity implements MainContract.View {

    private MainContract.Presenter mainPresenter;


    EditText inputA;
    EditText inputB;

    String nA;
    String nB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresenter = new MainPresenter(this);
//        mainPresenter.setView(this);
//        mainPresenter.loadItems(getApplicationContext(), false);

        initListener();
    }

    private void initListener(){
        inputA = findViewById(R.id.editInputA);
        inputB = findViewById(R.id.editInputB);

        nA = inputA.getText().toString();
        nB = inputB.getText().toString();




        // '=' 버튼 클릭 시 덧셈 결과 받기
        findViewById(R.id.btnResult).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.addNums(1, 2);
            }
        });
    }
    @Override
    public void showResult(int result){
        ((TextView)findViewById(R.id.txtResult)).setText(Integer.toString(result));
    }
}

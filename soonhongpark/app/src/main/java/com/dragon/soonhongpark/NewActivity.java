package com.dragon.soonhongpark;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_main);

    }

    // 네이버 접속
    public void onButtonClick1(View v){
        Toast.makeText(this, "돌아가기 ",Toast.LENGTH_LONG).show();
        finish();
    }


}

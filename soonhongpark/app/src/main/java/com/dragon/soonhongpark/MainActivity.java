package com.dragon.soonhongpark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // 네이버 접속
    public void onButtonClick1(View v){
        Toast.makeText(this, "버튼눌렀다 ",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Intent.ACTION_VIEW,  Uri.parse("http://m.naver.com"));
        startActivity(intent);
    }

    // 전화 걸기
    public void onButtonClick2(View v){
        Toast.makeText(this, "전화를 걸거야 ",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Intent.ACTION_VIEW,  Uri.parse("tel:010-4123-2517"));
        startActivity(intent);
    }

    // 화면이동
    public void onButtonClick3(View v){
        Toast.makeText(this, "다른 화면 갈거야 ",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(), NewActivity.class);
        startActivity(intent);
    }

}

package com.dragon.soonhongpark;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EventActivity extends AppCompatActivity {

    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_main);

        textView = findViewById(R.id.textView5);
        View view = findViewById(R.id.view);

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();

                float curX = event.getX();
                float curY = event.getY();

                if (action == MotionEvent.ACTION_DOWN) {
                    println("손가락 눌림 | x : " + curX + " | " + curY);
                } else if (action == MotionEvent.ACTION_MOVE) {
                    println("손가락 움직임 | x : " + curX + " | " + curY);
                } else if (action == MotionEvent.ACTION_UP) {
                    println("손가락 뗌 | x : " + curX + " | " + curY);
                }
                return true;
            }
        });
    }

    public void println(String data){

        textView.append(data + "\n");


    }


}

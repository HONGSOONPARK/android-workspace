package com.stepup.kotlinstd2

import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import kotlinx.android.synthetic.main.runonui_thread.*
import java.util.*


class RunOnUiThreadActivity : BaseActivity() {

    // RunOnUiThread
    // 개발자가 발생시킨 일반 쓰래드에서 코드 일부를 Main Thread 가 처리하도록하는 메서드
    // Java : 메서드
    // Kotlin : 람다

    // 일반 Thread 운영 중 화면 처리를 간편히 할 수 있다.

    lateinit var currentTime: Date
    var isRunning:Boolean= true;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.runonui_thread)


        rotButton1.setOnClickListener{
            currentTime = Calendar.getInstance().time
            rotText1.text = "버튼 클릭 :${currentTime}"
        }

        isRunning = true
        var thread = ThreadClass2()
        thread.start()

    }

    inner class ThreadClass2 : Thread(){

        override fun run() {
            while(isRunning){
                SystemClock.sleep(100)
                currentTime = Calendar.getInstance().time
                Log.d("ThreadClass2","$currentTime")

                runOnUiThread{
                    rotText2.text = "쓰레드 : $currentTime"
                }

            }


        }
    }


    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }
}
package com.stepup.kotlinstd2


import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import androidx.appcompat.widget.Toolbar

import kotlinx.android.synthetic.main.thread_handler.*
import java.util.*


class ThreadHandlerActivity : BaseActivity() {

    // Thread : 비 동기적 처리할때 사용
    // Main Thread 에서만 화면(Activity) 처리 가능
    // 네트워크 관련 모두 Thread로 처리

    // Handler : 특정 코드를 Main Thread로 하여금 반복해서 작업가능, 안드로이드 OS에게 작업 수행 요청
    // 안드로이드 OS가 작업하지 않을때 요청 작업 처리
    // Main Thread 에서 처리
    // 5초 이상 걸리는 작업 불가
    // 화면 처리 가능
    //

    var isRunning = true;
    lateinit var currentTime: Date

    var handler : Handler? = null
    var displayHandler : DisplayHandler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.thread_handler)

        // 툴바 설정
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val ab = supportActionBar!!
        ab.setDisplayShowTitleEnabled(false)



        handler = Handler()
        displayHandler = DisplayHandler()
        // 쓰레드
        var thread = ThreadClass1()

        //handler?.post(thread)
        displayHandler?.postDelayed(thread,100)

        button1.setOnClickListener{
            currentTime = Calendar.getInstance().time
            time1.text = "버튼 클릭 :${currentTime}"
        }
//            thread.start()
    }

    inner class ThreadClass1 : Thread(){

        override fun run() {
//            while(isRunning){
//                SystemClock.sleep(1000)
            currentTime = Calendar.getInstance().time
            //val onlyDate: LocalDateTime = LocalDateTime.now()
            //time1.text = "현재시간 :$onlyDate";
            Log.d("ThreadClass1","$currentTime")
//                time1.text = "Handler : $currentTime"
            //handler?.post(this)
            //displayHandler?.sendEmptyMessage(0)
            var msg = Message()
            msg.what = 0
            msg.obj = currentTime
            displayHandler?.sendMessage(msg)
//            }
        }
    }

    inner class DisplayHandler : Handler(){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            Log.d("handler", msg.toString())
            //currentTime = Calendar.getInstance().time
            //time2.text = "DisplayHandler : $currentTime"

            time2.text = "DisplayHandler : ${msg?.obj}"
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        for(idx in grantResults.indices){
            if(grantResults[idx] == PackageManager.PERMISSION_GRANTED){
                //grantText.append("${permissions[idx]} : 허용함 \n")
                Log.d("홍이홍","${permissions[idx]} : 허용함 \\n")
            }else{
                //grantText.append("${permissions[idx]} : 허용하지 않음 \n")
                Log.d("홍이홍","${permissions[idx]} : 허용하지 않음 \\n")
            }
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }
}
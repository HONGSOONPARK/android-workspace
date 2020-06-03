package com.stepup.kotlinstd2

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.SystemClock
import android.util.Log
import java.lang.UnsupportedOperationException


// 일반 서비스
class ServiceClass1 : Service(){

    override fun onBind(intent: Intent): IBinder? {
        throw UnsupportedOperationException("Not Yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        var thread = ThreadClass1()
        thread.start()

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("service1", "service Stop:")
    }

    inner class ThreadClass1 : Thread(){

        override fun run(){
            var idx = 0
            while(idx < 10){
                SystemClock.sleep(1000)
                var time = System.currentTimeMillis()
                Log.d("service1", "service Running: $time")
                idx++
            }
        }
    }

}
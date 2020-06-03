package com.stepup.kotlinstd2

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.IBinder
import android.os.SystemClock
import android.util.Log
import androidx.core.app.NotificationCompat
import java.lang.UnsupportedOperationException


//포그라운드

class ServiceClass3 : Service() {


    var builder : NotificationCompat.Builder? = null
    override fun onBind(intent: Intent): IBinder {
        throw UnsupportedOperationException("Not Yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ){
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            var channel = NotificationChannel("test1","Service", NotificationManager.IMPORTANCE_DEFAULT)
            channel.enableLights(true)
            channel.lightColor = Color.RED
            channel.enableVibration(true)
            manager.createNotificationChannel(channel)

            builder = NotificationCompat.Builder(this, "test1")
        }else{
            builder = NotificationCompat.Builder(this)
        }

        builder?.setSmallIcon(android.R.drawable.ic_menu_search)
        builder?.setContentTitle("서비스 가동")
        builder?.setContentText("서비스 가동중이다")
        var notification = builder?.build()

        startForeground(10,notification)



        var thread = ThreadClass1()
        thread.start()

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("service3", "service Stop:")
        builder = null
    }

    inner class ThreadClass1 : Thread(){

        override fun run(){
            var idx = 0
            while(idx < 5){
                SystemClock.sleep(1000)
                var time = System.currentTimeMillis()
                Log.d("service1", "service Running: $time")
                idx++
            }

            stopForeground(true)
        }
    }
}

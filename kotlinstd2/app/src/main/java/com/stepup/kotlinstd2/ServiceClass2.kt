package com.stepup.kotlinstd2

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.os.SystemClock
import android.util.Log

// TODO: Rename actions, choose action names that describe tasks that this
// IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
private const val ACTION_FOO = "com.stepup.kotlinstd2.action.FOO"
private const val ACTION_BAZ = "com.stepup.kotlinstd2.action.BAZ"

// TODO: Rename parameters
private const val EXTRA_PARAM1 = "com.stepup.kotlinstd2.extra.PARAM1"
private const val EXTRA_PARAM2 = "com.stepup.kotlinstd2.extra.PARAM2"

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */

// 인텐스 서비스
class ServiceClass2 : IntentService("ServiceClass2") {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)

    }

    override fun onHandleIntent(intent: Intent?) {

        var idx = 0
        while(idx < 10){
            SystemClock.sleep(1000)
            var time = System.currentTimeMillis()
            Log.d("service2", "intent service Running: $time")
            idx++
        }
    }


}

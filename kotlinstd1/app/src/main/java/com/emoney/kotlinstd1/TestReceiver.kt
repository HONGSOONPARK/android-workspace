package com.emoney.kotlinstd1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class TestReceiver() : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("test","test")
        var t1 = Toast.makeText(context, "std111 receiver start", Toast.LENGTH_SHORT)
        t1.show()
    }
}

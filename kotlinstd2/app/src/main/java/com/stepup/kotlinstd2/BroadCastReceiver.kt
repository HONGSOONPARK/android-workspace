package com.stepup.kotlinstd2

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.broadcast.*


class BroadCastReceiver : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.broadcast)

        go_broadcast.setOnClickListener{
            var intent = Intent()
            intent.setClassName("com.emoney.kotlinstd1","com.emoney.kotlinstd1.TestReceiver")
            sendBroadcast(intent)
        }
    }

}
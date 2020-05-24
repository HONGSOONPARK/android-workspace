package com.stepup.kotlinstd2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.other_app.*
import kotlinx.android.synthetic.main.second_activity.*


class OtherAppActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.other_app)

        other_app.setOnClickListener{
            var it = Intent("com.emoney.kotlinstd1")
            startActivity(it)
        }
    }

}
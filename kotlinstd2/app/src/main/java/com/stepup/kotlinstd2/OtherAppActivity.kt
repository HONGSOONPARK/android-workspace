package com.stepup.kotlinstd2

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import kotlinx.android.synthetic.main.other_app.*
import kotlinx.android.synthetic.main.second_activity.*


class OtherAppActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.other_app)

        other_app1.setOnClickListener{
            var it = Intent("kotlinstd1")
            startActivity(it)
        }

        other_app2.setOnClickListener{
            var uri = Uri.parse("geo:37.343243,131.861601")
            var it = Intent(Intent.ACTION_VIEW, uri)
            startActivity(it)
        }

        other_app3.setOnClickListener{
            var uri = Uri.parse("https://m.naver.com")
            var it = Intent(Intent.ACTION_VIEW, uri)
            startActivity(it)
        }

        other_app4.setOnClickListener{
            var uri = Uri.parse("tel:01041232517")
            //var it = Intent(Intent.ACTION_DIAL, uri)
            var it = Intent(Intent.ACTION_CALL, uri)
            startActivity(it)
        }

    }

}
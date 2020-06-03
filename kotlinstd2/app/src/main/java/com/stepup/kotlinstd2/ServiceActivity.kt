package com.stepup.kotlinstd2


import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.service.*


class ServiceActivity : BaseActivity() {



    private var serviceIntent: Intent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.service)

        // 툴바 설정
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val ab = supportActionBar!!
        ab.setDisplayShowTitleEnabled(false)


        service_start.setOnClickListener{
            serviceIntent = Intent(this, ServiceClass1::class.java)
            startService(serviceIntent)
            finish()
        }

        service_stop.setOnClickListener {
            stopService(serviceIntent)
        }

        intent_service_start.setOnClickListener{
            serviceIntent = Intent(this, ServiceClass2::class.java)
            startService(serviceIntent)
            finish()
        }

        foreground_service_start.setOnClickListener{
            serviceIntent = Intent(this, ServiceClass3::class.java)
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ){
                startForegroundService(serviceIntent)
            }else{
                startService(serviceIntent)
            }

        }

    }

}
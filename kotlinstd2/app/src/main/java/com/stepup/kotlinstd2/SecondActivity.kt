package com.stepup.kotlinstd2

import android.app.Activity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import kotlinx.android.synthetic.main.runonui_thread.*
import kotlinx.android.synthetic.main.second_activity.*
import java.util.*


class SecondActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.second_activity)


        button_finish.setOnClickListener{
            setResult(Activity.RESULT_OK) // 실행 성공
//        setResult(Activity.RESULT_FIRST_USER) // 그 외 여러가지 대응
//        setResult(Activity.RESULT_CANCELED) // 실행 사용자가 취소
            // 정수값으로 되어있음
            finish()
        }
    }
    
}
package com.stepup.kotlinstd2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.second_activity.*


class SecondActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        var data1 = intent.getStringExtra("edit1")
        var data2 = intent.getStringExtra("edit2")

        second_text.append("\n$data1|$data2")

        go_second.setOnClickListener{
            var it = Intent()
            it.putExtra("edit1",data1)
            it.putExtra("edit2",data2)
            setResult(Activity.RESULT_OK, it) // 실행 성공
//        setResult(Activity.RESULT_FIRST_USER) // 그 외 여러가지 대응
//        setResult(Activity.RESULT_CANCELED) // 실행 사용자가 취소
            // 정수값으로 되어있음
            finish()
        }
    }

}
package com.stepup.kotlinstd2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.second_activity.*


class SendObjectActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.send_object)

        var t1 = intent.getParcelableExtra<TestClass>("test1")

        object_text.text = "t1.data10 : ${t1.data10}\n"
        object_text.append("t1.data20 : ${t1.data20}")


        object_finish.setOnClickListener{

            var t2 = TestClass()
            t2.data10 = 200
            t2.data20 = "문자열222"

            var it = Intent()
            it.putExtra("test2",t2)
            setResult(Activity.RESULT_OK, it) // 실행 성공
//        setResult(Activity.RESULT_FIRST_USER) // 그 외 여러가지 대응
//        setResult(Activity.RESULT_CANCELED) // 실행 사용자가 취소
            // 정수값으로 되어있음
            finish()
        }
    }

}
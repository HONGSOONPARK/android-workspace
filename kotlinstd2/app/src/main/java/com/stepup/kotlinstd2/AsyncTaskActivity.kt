package com.stepup.kotlinstd2


import android.content.Context
import android.content.pm.PackageManager
import android.os.*
import android.util.Log
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.aynctask.*

import kotlinx.android.synthetic.main.thread_handler.*
import java.util.*


class AsyncTaskActivity : BaseActivity() {

    // AsyncTask : 비 동기처리 클래스
    // AsyncTask 사용하면 개발자가 발생시키는 일반 쓰래드와 화면처리를 위해 Main Thread를 이용하는 것을 조합하여 작업가능


    lateinit var currentTime: Date

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.aynctask)
        asyncButton1.setOnClickListener{
            currentTime = Calendar.getInstance().time
            asyncText1.text = "버튼 클릭 :${currentTime}"
        }

        var sync = AsyncTaskClass()
        sync.execute(10,20)

    }

    inner class AsyncTaskClass : AsyncTask<Int, Long, String>(){

        override fun doInBackground(vararg params: Int?): String? {

            var a1 = params[0]!!
            var a2 = params[1]!!

            for(idx in 0..9){
               SystemClock.sleep(1000)

                a1++
                a2++

                Log.d("doInBackground", "$a1 | $a2")
                var time = System.currentTimeMillis()

                publishProgress(time)
            }



            return "수행이 완료되었습니다."
        }

        override fun onProgressUpdate(vararg values: Long?) {
            super.onProgressUpdate(*values)
            asyncText2.text = "Async : ${values[0]}"
        }

        override fun onPreExecute() {
            super.onPreExecute()
            asyncText1.text = "AsyncTask 가동"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            asyncText1.text = result
        }
    }

}
package com.stepup.kotlinstd2


import android.content.Intent
import android.content.pm.PackageManager
import android.os.*
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : BaseActivity() {




        private var permissionList = arrayOf(
            android.Manifest.permission.INTERNET,
            android.Manifest.permission.CAMERA,
            android.Manifest.permission.SEND_SMS,
            android.Manifest.permission.READ_CONTACTS
        )

        private var data:Array<String> = arrayOf("Thread, Handler","AyncTask","Run On Ui Thread")

        lateinit var currentTime: Date

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)


            checkPermission()
            // 리스트 어댑터
            val mainListAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
            main_listView.adapter = mainListAdapter

            main_listView.onItemClickListener = listListener

    }

    private var listListener = AdapterView.OnItemClickListener { parent, view, position, id ->

        Log.d("listListener", "$parent|$view|$position|$id")
        val it: Intent

        //textView.text = data[position]
        when(data[position]){
            "Thread, Handler" ->{
                it = Intent(this, ThreadHandlerActivity::class.java)
                startActivity(it)
            }

            "AyncTask" ->{
                it = Intent(this, AsyncTaskActivity::class.java)
                startActivity(it)
            }

            "Run On Ui Thread" ->{
                it = Intent(this, RunOnUiThreadActivity::class.java)
                startActivity(it)
            }


        }

    }
    private fun checkPermission(){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            return
        }
        for(permission : String in permissionList){
            var chk = checkCallingOrSelfPermission(permission)

            if(chk == PackageManager.PERMISSION_DENIED){
                requestPermissions(permissionList, 0)
                break;
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}

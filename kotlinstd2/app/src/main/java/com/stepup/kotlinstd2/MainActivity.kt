package com.stepup.kotlinstd2


import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.os.*
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : BaseActivity() {
        private val SECOND_ACTIVITY = 2
        private val SEND_OBJECT = 3

        private var permissionList = arrayOf(
                android.Manifest.permission.INTERNET,
                android.Manifest.permission.CAMERA,
                android.Manifest.permission.SEND_SMS,
                android.Manifest.permission.READ_CONTACTS,
                android.Manifest.permission.CALL_PHONE
            )

        private var data:Array<String> = arrayOf(
                "Thread, Handler",
                "AyncTask",
                "Run On Ui Thread",
                "SecondActivity Start",
                "Send Object",
                "Other Application",
                "BroadCast Receiver",
                "Service"
        )

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
        var it: Intent
        var builder = AlertDialog.Builder(this)

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

            "SecondActivity Start" ->{
                builder.setTitle("Intent 테스트")
                builder.setIcon(R.mipmap.ic_launcher)

                var v1 = layoutInflater.inflate(R.layout.dialog, null)

                builder.setView(v1)
                builder.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, p1 ->

                    var alert = dialog as AlertDialog

                    var edit1: EditText? = alert.findViewById<EditText>(R.id.editText1)
                    var edit2: EditText? = alert.findViewById<EditText>(R.id.editText2)

                    when(p1){
                        DialogInterface.BUTTON_POSITIVE -> {
                            if("${edit1?.text}"!= null && "${edit2?.text}"!= null){
                                it = Intent(this, SecondActivity::class.java)
                                it.putExtra("edit1",(edit1?.text).toString())
                                it.putExtra("edit2",(edit2?.text).toString())

                                startActivityForResult(it, SECOND_ACTIVITY)
                            }else{
                                Toast.makeText(this, "두개 필수로 입력해야함 ", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                  })
                builder.setNegativeButton("취소", null)
                builder.show()
            }

            "Send Object" ->{

                var t1 = TestClass()
                t1.data10 = 100
                t1.data20 = "문자열1"

                it = Intent(this, SendObjectActivity::class.java)
                it.putExtra("test1", t1)

                startActivityForResult(it,SEND_OBJECT)
            }

            "Other Application" ->{
                it = Intent(this, OtherAppActivity::class.java)
                startActivity(it)
            }

            "BroadCast Receiver" ->{
                it = Intent(this, BroadCastReceiver::class.java)
                startActivity(it)
            }

            "Service" ->{
                it = Intent(this, ServiceActivity::class.java)
                startActivity(it)
            }




        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("onActivityResult", "$requestCode|$resultCode|$data")

        when(requestCode){
            SECOND_ACTIVITY ->{
                Toast.makeText(this, "SecondActivity에서 돌아옴 :${resultCode}|${data?.getStringExtra("edit1")}|${data?.getStringExtra("edit2")}", Toast.LENGTH_SHORT).show()
            }
            SEND_OBJECT ->{
                var t2 = data?.getParcelableExtra<TestClass>("test2")
                Toast.makeText(this, "SecondActivity에서 돌아옴 :${resultCode}|${t2?.data10}|${t2?.data20}", Toast.LENGTH_SHORT).show()
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

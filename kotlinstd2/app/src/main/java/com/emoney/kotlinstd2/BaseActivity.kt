package com.emoney.kotlinstd2

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DialogTitle
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.base_top.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import android.widget.SimpleAdapter

open class BaseActivity : AppCompatActivity() {


    private var testData1 = arrayOf("일번","이번","삼번")
    private var testData2 = intArrayOf(android.R.drawable.btn_dropdown,android.R.drawable.ic_lock_idle_lock, android.R.drawable.presence_video_busy)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_top);
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // xml 활용
        menuInflater.inflate(R.menu.option_menu, menu)


        // code 활용

//        menu?.add(Menu.NONE, Menu.FIRST +1, Menu.NONE, "코드메뉴1")
//        menu?.add(Menu.NONE, Menu.FIRST +2, Menu.NONE, "코드메뉴2")
//
//        var sub:Menu?= menu?.addSubMenu("코드메뉴3")
//        sub?.add(Menu.NONE,Menu.FIRST+3, Menu.NONE, "코드메뉴3_1")



        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        var builder = AlertDialog.Builder(this)
        builder.setTitle("기본 다이얼로그")
        builder.setIcon(R.mipmap.ic_launcher)

        // xml 활용
        when(item?.itemId){
            R.id.menu_1 -> {
                Toast.makeText(this, "menu1", Toast.LENGTH_SHORT).show()
            }
            R.id.menu_1_2 -> {
                Toast.makeText(this, "커스텀다이얼로그", Toast.LENGTH_SHORT).show()

                builder.setMessage("커스텀다이얼로그 본문")

                var v1 = layoutInflater.inflate(R.layout.dialog, null)

                builder.setView(v1)
                builder.setPositiveButton("확인", dialogListener)
                builder.setNegativeButton("취소", dialogListener)
                builder.setNeutralButton("닫기", dialogListener)

                builder.show()

            }
            R.id.menu_2 ->{
                Toast.makeText(this, "다이얼로그", Toast.LENGTH_SHORT).show()
                builder.setMessage("다이얼로그의 본문")

                builder.setPositiveButton("확인", dialogListener)
                builder.setNegativeButton("취소", dialogListener)
                builder.setNeutralButton("닫기", dialogListener)

                builder.show()
            }

            R.id.menu_3 ->{
                Toast.makeText(this, "달력", Toast.LENGTH_SHORT).show()

                var calendar = Calendar.getInstance()
                var year = calendar.get(Calendar.YEAR)
                var month = calendar.get(Calendar.MONTH)
                var day = calendar.get(Calendar.DAY_OF_MONTH)

                var picker = DatePickerDialog(this, calendarListener, year, month, day)
                picker.show()

            }

            R.id.menu_4 ->{
                Toast.makeText(this, "시계", Toast.LENGTH_SHORT).show()

                var calendar = Calendar.getInstance()
                var hour = calendar.get(Calendar.HOUR)
                var minute = calendar.get(Calendar.MINUTE)


                var time_picker = TimePickerDialog(this, timeListener, hour, minute, false)

                time_picker.show()

            }

            R.id.menu_5 ->{

                Toast.makeText(this, "커스텀리스트 다이얼로그", Toast.LENGTH_SHORT).show()

                builder.setMessage("커스텀리스트")

                var list = ArrayList<HashMap<String,Any>>()

                var idx = 0
                while(idx < testData1.size){

                    var map = HashMap<String,Any>()
                    map["testData1"] = testData1[idx]
                    //map["testData2"] = testData2[idx]

                    list.add(map)
                    idx++
                }

                var keys = arrayOf("testData1")
                var ids = intArrayOf(R.id.text_dialog)

                var adapter2 = SimpleAdapter(this, list, R.layout.list_dialog, keys, ids)

                builder.setAdapter(adapter2, null)
//                builder.setItems(testData1,null)
                builder.setNegativeButton("취소", dialogListener)
                builder.show()
            }
        }

        // 코드활용

//        when(item?.itemId){
//            Menu.FIRST + 1 ->
//                Toast.makeText(this, "menu1", Toast.LENGTH_SHORT).show()
//
//            Menu.FIRST + 2 ->
//                Toast.makeText(this, "menu2", Toast.LENGTH_SHORT).show()
//
//            Menu.FIRST + 3 ->
//                Toast.makeText(this, "menu3_1", Toast.LENGTH_SHORT).show()
//
//        }


        return super.onOptionsItemSelected(item)
    }



    // 달력 리스너

    private var calendarListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
        Log.d("홍이홍","DatePickerDialog")
        Toast.makeText(this, "${year+1}년/${month}월/${dayOfMonth}일" , Toast.LENGTH_SHORT).show()
    }

    private var timeListener = TimePickerDialog.OnTimeSetListener { view, hour, minute ->
        Log.d("홍이홍","DatePickerDialog")
        Toast.makeText(this, "${hour}시${minute}분" , Toast.LENGTH_SHORT).show()
    }



    // 다이얼로그 리스너
    private var dialogListener = DialogInterface.OnClickListener { dialog, p1 ->

        var alert = dialog as AlertDialog

        var edit1:EditText? = alert.findViewById<EditText>(R.id.editText1)
        var edit2:EditText? = alert.findViewById<EditText>(R.id.editText2)

        when(p1){
            DialogInterface.BUTTON_POSITIVE -> {
                Log.d("홍이홍","BUTTON_POSITIVE")

                if("${edit1?.text}"!= null){
                    Log.d("홍이홍", "${edit1?.text}")
                    Log.d("홍이홍", "${edit2?.text}")
                }
            }

            DialogInterface.BUTTON_NEGATIVE -> {
                Log.d("홍이홍","BUTTON_NEGATIVE")
            }

            DialogInterface.BUTTON_NEUTRAL -> {
                Log.d("홍이홍","BUTTON_NEUTRAL")
            }
        }
    }



    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onStop() {
        super.onStop()
    }

    override fun setContentView(layoutResID: Int) {

        var fullView:LinearLayout = getLayoutInflater().inflate(R.layout.base_top, null) as LinearLayout

        var activityContainer:FrameLayout = fullView.findViewById (R.id.activity_content);
        layoutInflater.inflate(layoutResID, activityContainer, true);

        super.setContentView(fullView);

        var toolbar:Toolbar = findViewById (R.id.toolbar);

        var tv: TextView = findViewById (R.id.textView);

        //툴바 사용여부 결정(기본적으로 사용)
        if (useToolbar()) {
            setSupportActionBar(toolbar);
            //title = "툴바예제";
            tv.text = javaClass.simpleName
        } else {
            toolbar.visibility = View.GONE;
        }
    }

    //툴바를 사용할지 말지 정함
    protected open fun useToolbar() : Boolean{
        return true;
    }




}
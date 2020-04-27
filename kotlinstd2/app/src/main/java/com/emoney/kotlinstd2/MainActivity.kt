package com.emoney.kotlinstd2


import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.base_top.*


class MainActivity : BaseActivity() {
    private var data:Array<String> = arrayOf("ViewPager","TwoLineListView","CustomListView")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)

        // 툴바 설정
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val ab = supportActionBar!!
        ab.setDisplayShowTitleEnabled(false)


        // 상단버튼
        button1.setOnClickListener(btnListener)
        button2.setOnClickListener(btnListener)

        // 리스트 어댑터
        val mainListAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        main_listView.adapter = mainListAdapter

        main_listView.onItemClickListener = listListener

    }

    // 버튼 리스너
    private var btnListener = View.OnClickListener { view ->
        when(view.id){
            R.id.button1 -> {
                textView.text = "첫번재 버튼"
            }

            R.id.button2 -> {
                textView.text = "두번재 버튼"
            }
        }
    }



    private var listListener = AdapterView.OnItemClickListener { parent, view, position, id ->

        Log.d("listListener", "$parent|$view|$position|$id")
        val it: Intent

        //textView.text = data[position]
        when(data[position]){
            "ViewPager" ->{
                it = Intent(this, ViewActivity::class.java)
                startActivity(it)
            }
            "TwoLineListView" ->{
                it = Intent(this, TwoLineListActivity::class.java)
                startActivity(it)
            }

            "CustomListView" ->{
                it = Intent(this, CustomListActivity::class.java)
                startActivity(it)
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
}
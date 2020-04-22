package com.emoney.kotlinstd2


import android.content.Intent
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.ArrayAdapter


import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.viewpager.*
import kotlin.math.log
import kotlinx.android.synthetic.main.activity_main.textView as textView1


class MainActivity : AppCompatActivity() {
    var view_list = ArrayList<View>()

    var data = arrayOf("리스트1","리스트2","리스트3","리스트4","리스트5","리스트6","리스트7","리스트8")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)

        var listener1 = BtnListner()

//        button1.setOnClickListener(btnListener);
//        button2.setOnClickListener(btnListener);

        var main_adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        main_listView.adapter = main_adapter

//        var listener = ListListener()
//        main_listView.setOnItemClickListener(listener)

        main_listView.setOnItemClickListener { parent, view, position, id ->
            textView.text = data[position]

        }
    }

    inner class ListListener: AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            textView.text = data[position]
        }
    }


    inner class BtnListner:View.OnClickListener{
        override fun onClick(v: View?) {

        }
    }

    var btnListener = View.OnClickListener { view ->

        when(view.id){
//            R.id.button1 -> {
//                textView.text = "첫번재 버튼"
//
//
//            }
//
//            R.id.button2 -> {
//                textView.text = "두번재 버튼"
//            }
        }


    }





}
package com.emoney.kotlinstd2


import android.content.Intent
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent


import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.viewpager.*
import kotlin.math.log
import kotlinx.android.synthetic.main.activity_main.textView as textView1


class MainActivity : AppCompatActivity() {
    var view_list = ArrayList<View>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listener1 = BtnListner()

        button1.setOnClickListener(listener1);

        button2.setOnClickListener(btnListener);


    }

    inner class BtnListner:View.OnClickListener{
        override fun onClick(v: View?) {

        }
    }

    var btnListener = View.OnClickListener { view ->

        when(view.id){
            R.id.button1 -> {
                textView.text = "첫번재 버튼"
            }

            R.id.button2 -> {
                textView.text = "button2 버튼"
            }

        }


    }





}
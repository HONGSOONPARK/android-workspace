package com.emoney.kotlinstd2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.base_top.*

open class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_top);


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
package com.stepup.kotlinstd2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_top);
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // xml 활용
        menuInflater.inflate(R.menu.option_menu, menu)
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

        }



        return super.onOptionsItemSelected(item)
    }




    override fun setContentView(layoutResID: Int) {

        var fullView:LinearLayout = layoutInflater.inflate(R.layout.base_top, null) as LinearLayout
        var activityContainer:FrameLayout = fullView.findViewById (R.id.activity_content);
        layoutInflater.inflate(layoutResID, activityContainer, true);

        super.setContentView(fullView);

        var toolbar:Toolbar = findViewById(R.id.toolbar)
        var tv: TextView = findViewById (R.id.textView);

        //툴바 사용여부 결정(기본적으로 사용)
        if (useToolbar()) {
            setSupportActionBar(toolbar)
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
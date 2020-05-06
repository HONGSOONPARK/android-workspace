package com.emoney.kotlinstd2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.base_top.*

open class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_top);
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // xml 활용
        //menuInflater.inflate(R.menu.option_menu, menu)


        // code 활용

        menu?.add(Menu.NONE, Menu.FIRST +1, Menu.NONE, "코드메뉴1")
        menu?.add(Menu.NONE, Menu.FIRST +2, Menu.NONE, "코드메뉴2")

        var sub:Menu?= menu?.addSubMenu("코드메뉴3")
        sub?.add(Menu.NONE,Menu.FIRST+3, Menu.NONE, "코드메뉴3_1")



        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        // xml 활용
//        when(item?.itemId){
//            R.id.menu_1 ->
//                Toast.makeText(this, "menu1", Toast.LENGTH_SHORT).show()
//            R.id.menu_1_2 ->
//                Toast.makeText(this, "menu1-2", Toast.LENGTH_SHORT).show()
//            R.id.menu_2 ->
//                Toast.makeText(this, "menu2", Toast.LENGTH_SHORT).show()
//        }

        // 코드활용

        when(item?.itemId){
            Menu.FIRST + 1 ->
                Toast.makeText(this, "menu1", Toast.LENGTH_SHORT).show()

            Menu.FIRST + 2 ->
                Toast.makeText(this, "menu2", Toast.LENGTH_SHORT).show()

            Menu.FIRST + 3 ->
                Toast.makeText(this, "menu3_1", Toast.LENGTH_SHORT).show()

        }


        return super.onOptionsItemSelected(item)
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
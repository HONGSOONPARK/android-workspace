package com.emoney.kotlinstd2


import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.base_top.*


class MainActivity : BaseActivity() {
    var view_list = ArrayList<View>()

    var data = arrayOf("ViewPager")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)
        textView.text = "Main"
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val ab = supportActionBar!!
        ab.setDisplayShowTitleEnabled(false)

        var listener1 = BtnListner()

        // 상단버튼
        button1.setOnClickListener(btnListener);
        button2.setOnClickListener(btnListener);

        // 리스트 어댑터
        var main_adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        main_listView.adapter = main_adapter

//        main_listView.setOnItemClickListener { parent, view, position, id ->
//            textView.text = data[position]
//            view.setOnClickListener(btnListener)
//        }

        main_listView.setOnItemClickListener(listListner);

    }


    //        var listener = ListListener()
//        main_listView.setOnItemClickListener(listener)


    inner class ListListener: AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            //textView.text = data[position]
        }
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
                textView.text = "두번재 버튼"
            }
        }
    }



    var listListner = AdapterView.OnItemClickListener { parent, view, position, id ->

//        Log.d("홍이홍",  "|"+ view+"|"+ position+"|"+ id )
        var it: Intent

        textView.text = data[position]
        when(data[position]){

            "ViewPager" ->{
                it = Intent(this, ViewActivity::class.java)
                startActivity(it)
            }

        }

    }




}
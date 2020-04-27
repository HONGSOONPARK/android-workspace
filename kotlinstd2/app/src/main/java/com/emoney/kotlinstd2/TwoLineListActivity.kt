package com.emoney.kotlinstd2

import android.os.Bundle
import android.util.Log
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.twolinelist.*

class TwoLineListActivity : BaseActivity() {


    var data1 = arrayOf("문자열1","문자열2","문자열3","문자열4","문자열5")
    var data2 = arrayOf("String1","String2","String3","String4","String5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.twolinelist);

        var list = ArrayList<HashMap<String, String>>()

        var idx = 0

        while(idx< data1.size){
            var map = HashMap<String, String>()
            map["str1"] = data1[idx]
            map["str2"] = data2[idx]
            list.add(map)

            idx++
        }

        var key = arrayOf("str1", "str2")

        var ids = intArrayOf(android.R.id.text1, android.R.id.text2)
        var adapter = SimpleAdapter(this, list, android.R.layout.simple_list_item_2, key, ids)
        twoLineList.adapter = adapter

        twoLineList.setOnItemClickListener { adapterView, view, position, id ->
            Log.d("twoLineList", "$adapterView|$view|$position|$id")
            twoLineText.text = data1[position]
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


    override fun useToolbar(): Boolean {
        return true;
    }
}
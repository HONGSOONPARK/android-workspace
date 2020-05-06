package com.emoney.kotlinstd2

import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.base_top.*
import kotlinx.android.synthetic.main.customlist.*
import kotlinx.android.synthetic.main.twolinelist.*

class CustomListActivity : BaseActivity() {

    var data:ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var idx:Int = 0
        while(idx < 100){
            data.add(idx, "데이터$idx")
            idx++
        }

        setContentView(R.layout.customlist);
        //var adapter = ArrayAdapter<String>(this, R.layout.customrow, R.id.customrow_text, data)
        var adapter = CustomListAdapter()
        custom_list.adapter = adapter
//        custom_list.setOnItemClickListener { parent, view, position, id ->
//
//            Log.d("홍이홍", "$parent|$view|$position|$id")
//
//            Toast.makeText(this, "리스트뷰 메뉴", Toast.LENGTH_SHORT).show()
//
//        }

        //custom_list.setOnClickListener(list_listener)


        // custom adpter 로 하면 context가 안나옴 흑흑
        registerForContextMenu(custom_list)

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        when(v?.id){
            R.id.custom_list -> {
                //Toast.makeText(this, "리스트뷰 메뉴", Toast.LENGTH_SHORT).show()
                menu?.setHeaderTitle("리스트뷰의 메뉴")
                menuInflater.inflate(R.menu.customlistview_menu, menu)
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId){
        }


        return super.onContextItemSelected(item)
    }

    inner class CustomListAdapter: BaseAdapter(){

        private var listener = BtnListener()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

            // 재사용 가능한 뷰를 변수에 담는다.
            var convertView:View? = convertView

            // 재사용 가능한 뷰가 없을때 새로 만든다.
            if(convertView == null){
                convertView = layoutInflater.inflate(R.layout.customrow, null)
            }

            // 뷰 객체로부터 텍스트 객체 추출
            var text:TextView?= convertView?.findViewById<TextView>(R.id.customrow_text)

            var customButton1:Button? = convertView?.findViewById<Button>(R.id.customrow_btn1)
            var customButton2:Button? = convertView?.findViewById<Button>(R.id.customrow_btn2)

            customButton1?.setOnClickListener(listener)
            customButton2?.setOnClickListener(listener)

            // 태그 등록하여 어떤 객체 선택했는지 확인
            customButton1?.tag =position
            customButton2?.tag =position


            // 텍스트 객체에 데이터 넣음
            text?.text = data.get(position)

            return convertView
        }

        override fun getItem(position: Int): Any? {
            return null
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getCount(): Int {
            return data.size
        }
    }


    inner class BtnListener : View.OnClickListener{
        override fun onClick(v: View?) {

            var position = v?.tag as Int

            when(v?.id){
                R.id.customrow_btn1 -> {
                    customText.text = "${position} : 첫 번째 버튼 누름"
                }
                R.id.customrow_btn2 -> {
                    customText.text = "${position} : 두 번째 버튼 누름"
                }
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


    override fun useToolbar(): Boolean {
        return true;
    }
}
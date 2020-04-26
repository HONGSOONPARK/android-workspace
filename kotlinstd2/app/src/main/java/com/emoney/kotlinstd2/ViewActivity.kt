package com.emoney.kotlinstd2


import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.base_top.*
import kotlinx.android.synthetic.main.viewpager.*


class ViewActivity : BaseActivity() {
    var view_list = ArrayList<View>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.viewpager)

        view_list.add(layoutInflater.inflate(R.layout.view1, null))
        view_list.add(layoutInflater.inflate(R.layout.view2, null))
        view_list.add(layoutInflater.inflate(R.layout.view3, null))
        pager.adapter = CustomAdapter()
                pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
                    override fun onPageScrollStateChanged(p0: Int) {
                    }
                    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
                        textView.text = "${p0} 번째 뷰가 나타났습니다"
            }
            override fun onPageSelected(p0: Int) {
            }
        })
    }

    inner class CustomAdapter : PagerAdapter() {
        override fun getCount(): Int {
            return view_list.size
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view == `object`
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {

            pager.addView(view_list[position])

            return view_list[position]
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            pager.removeView(`object` as View)
        }
    }

    override fun useToolbar(): Boolean {
        return true;
    }
}
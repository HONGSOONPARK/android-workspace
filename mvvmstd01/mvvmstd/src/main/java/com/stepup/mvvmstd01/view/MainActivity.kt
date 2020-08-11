package com.stepup.mvvmstd01.view

import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.stepup.mvvmstd01.MainSearchRecyclerViewAdapter
import com.stepup.mvvmstd01.R
import com.stepup.mvvmstd01.base.BaseKotlinActivity
import com.stepup.mvvmstd01.databinding.ActivityMainBinding
import com.stepup.mvvmstd01.model.Repo
import com.stepup.mvvmstd01.service.GitHubService
import com.stepup.mvvmstd01.viewmodel.MainViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : BaseKotlinActivity<ActivityMainBinding, MainViewModel>() {
        override val layoutResourceId: Int
            get() = R.layout.activity_main

        // koin을 활용한 DI 주입
        override val viewModel: MainViewModel by viewModel()
        private val mainSearchRecyclerViewAdapter: MainSearchRecyclerViewAdapter by inject()

        // 일반적인 DI 주입
        // override val viewModel: MainViewModel = MainViewModel()

    override fun initStartView() {
        main_activity_search_recycler_view.run {
            adapter = mainSearchRecyclerViewAdapter
            layoutManager = StaggeredGridLayoutManager(3, 1).apply {
                gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
                orientation = StaggeredGridLayoutManager.VERTICAL
            }
            setHasFixedSize(true)
        }
    }



    override fun initDataBinding() {
//        val service:GitHubService = Retrofit.Builder()
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl("http://api.github.com")
//            .build()
//            .create(GitHubService::class.java);
//
//        service.listRepos("USER")
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                // handle success
//                Log.d("홍순이","핸들 성공")
//            }, {
//                // handle fail
//                Log.d("홍순이","핸들 실패")
//            })


        viewModel.imageSearchResponseLiveData.observe(this, Observer {
            it.documents.forEach {document ->
                mainSearchRecyclerViewAdapter.addImageItem(document.image_url, document.doc_url)
            }
            mainSearchRecyclerViewAdapter.notifyDataSetChanged()
        })
    }

    override fun initAfterBinding() {
        main_activity_search_button.setOnClickListener {
            viewModel.getImageSearch(main_activity_search_text_view.text.toString(), 1, 80)
        }
    }

}
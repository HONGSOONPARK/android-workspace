package com.stepup.mvvmstd01.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.stepup.mvvmstd01.base.BaseKotlinViewModel
import com.stepup.mvvmstd01.model.DataModel
import com.stepup.mvvmstd01.model.Repo
import com.stepup.mvvmstd01.model.enum.KakaoSearchSortEnum
import com.stepup.mvvmstd01.model.response.ImageSearchResponse
import com.stepup.mvvmstd01.service.GitHubService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Retrofit


/**
 * 클래스 설명
 *
 * @author 최초작성자: 박홍순
 * @date 최초작성일: 2020-08-11 오전 9:45
 * BaseViewModel
 */
class MainViewModel(private val model: DataModel) : BaseKotlinViewModel() {

    private val TAG = "MainViewModel"

    private val _imageSearchResponseLiveData = MutableLiveData<ImageSearchResponse>()
    val imageSearchResponseLiveData:LiveData<ImageSearchResponse>
        get() = _imageSearchResponseLiveData

    fun getImageSearch(query: String, page:Int, size:Int) {
        addDisposable(model.getData(query, KakaoSearchSortEnum.Accuracy, page, size)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.run {
                    if (documents.size > 0) {
                        Log.d(TAG, "documents : $documents")
                        _imageSearchResponseLiveData.postValue(this)
                    }
                    Log.d(TAG, "meta : $meta")
                }
            }, {
                Log.d(TAG, "response error, message : ${it.message}")
            }))
    }
}





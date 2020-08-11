package com.stepup.mvvmstd01.model

import com.stepup.mvvmstd01.model.enum.KakaoSearchSortEnum
import com.stepup.mvvmstd01.model.response.ImageSearchResponse
import io.reactivex.Single

/**
 * 클래스 설명
 *
 * @author 최초작성자: 홍순박
 * @date 최초작성일: 2020-08-11 오전 9:47
 *
 */

interface DataModel {
    fun getData(query:String, sort: KakaoSearchSortEnum, page:Int, size:Int): Single<ImageSearchResponse>
}


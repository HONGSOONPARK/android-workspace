package com.stepup.mvvmstd01.model

import com.stepup.mvvmstd01.model.enum.KakaoSearchSortEnum
import com.stepup.mvvmstd01.model.response.ImageSearchResponse
import com.stepup.mvvmstd01.model.service.KakaoSearchService
import io.reactivex.Single

/**
 * 클래스 설명
 *
 * @author 최초작성자:
 * @date 최초작성일: 2020-08-11 오전 9:47
 *
 */

class DataModelImpl(private val service: KakaoSearchService):DataModel{

    private val KAKAO_APP_KEY = "96bbaae1889f48b83a2b19e939fe6069"

    override fun getData(query:String, sort: KakaoSearchSortEnum, page:Int, size:Int): Single<ImageSearchResponse> {
        return service.searchImage(auth = "KakaoAK $KAKAO_APP_KEY", query = query, sort = sort.sort, page = page, size = size)
    }
}
package com.stepup.mvvmstd01.service

import com.stepup.mvvmstd01.model.Repo
import io.reactivex.Single
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Path


/**
 * retrofit 테스트
 *
 * @author 최초작성자: 박홍순
 * @date 최초작성일: 2020-08-11 오후 2:53
 *
 */

interface GitHubService {
    @GET("/users/{user}/repos")
    fun listRepos(@Path("user") user:String): Single<Repo>
}
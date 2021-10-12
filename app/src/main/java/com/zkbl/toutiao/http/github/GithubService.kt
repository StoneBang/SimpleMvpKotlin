package com.zkbl.toutiao.http.github

import com.zkbl.toutiao.bean.GithubRepo
import com.zkbl.toutiao.bean.GithubUser
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Create by StoneBang at 2021/10/12
 */
open interface GithubService {
    @GET("/users/{user}")
    suspend  fun  getUserData(@Path("user") user: String): GithubUser// 获取个人信息Flow

    @GET("/users/{user}")
    fun  getUserDataCommon(@Path("user") user: String): Call<GithubUser>// 获取个人信息

    @GET("/users/{user}/repos")
    suspend  fun  getRepoData(@Path("user") user: String): Flow<Array<GithubRepo>>// 获取库, 获取的是数组

    companion object {
        const val ENDPOINT = "https://api.github.com"
    }
}
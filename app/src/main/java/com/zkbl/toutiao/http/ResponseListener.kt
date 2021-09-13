package com.zkbl.toutiao.http

/**
 * Create by StoneBang at 2021/9/13
 */
interface ResponseListener<T> {
    fun onSuccess(data:T)
    fun onFail(message:String)

}
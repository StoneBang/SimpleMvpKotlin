package com.zkbl.toutiao.base

/**
 * Create by StoneBang at 2021/9/12
 */
interface BaseView {
    fun <T> setData(data:T)
    fun setError(err:String)
}
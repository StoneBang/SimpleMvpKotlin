package com.zkbl.toutiao.mvp.view

/**
 * Create by StoneBang at 2021/9/12
 */
interface BaseView {
    fun <T> setData(data:T)
    fun setError(err:String)
}
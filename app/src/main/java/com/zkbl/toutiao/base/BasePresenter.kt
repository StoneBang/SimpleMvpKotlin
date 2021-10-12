package com.zkbl.toutiao.base

/**
 * Create by StoneBang at 2021/9/12
 */
open class BasePresenter<T> {
    private var mBaseView:T? = null

    fun bindView(baseView:T){
        this.mBaseView = baseView
    }
    fun unBindView(){
        this.mBaseView = null
    }
    fun getBaseView() = mBaseView
}
package com.zkbl.toutiao.base

/**
 * Create by StoneBang at 2021/9/12
 */
data class BaseModel<T>(val code:Int,val msg:String,val data:T)

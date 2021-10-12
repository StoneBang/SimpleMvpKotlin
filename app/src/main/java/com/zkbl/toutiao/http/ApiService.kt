package com.zkbl.toutiao.http

import com.zkbl.toutiao.base.BaseModel
import com.zkbl.toutiao.ui.model.GoodModel
import com.zkbl.toutiao.ui.model.ManuFactureModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

/**
 * Create by StoneBang at 2021/9/12
 */
interface ApiService{
    @GET("/wms_gk/api/base/getGoodsList")
    fun test1():Call<ResponseBody>
    @GET("/wms_gk/api/base/getGoodsList")
    fun test2():Call<Any>
    @GET("/wms_gk/api/base/getGoodsList")
    fun getGoodList(): Call<BaseModel<List<GoodModel>>>
    @GET("/wms_gk/api/base/getManufacturerList")
    fun getManufacturerList(): Call<BaseModel<List<ManuFactureModel>>>
}
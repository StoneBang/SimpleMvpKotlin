package com.zkbl.toutiao.http

import android.util.Log
import com.orhanobut.logger.Logger
import com.zkbl.toutiao.base.Constant
import com.zkbl.toutiao.mvp.model.BaseModel
import com.zkbl.toutiao.mvp.model.GoodModel
import com.zkbl.toutiao.mvp.model.ManuFactureModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Create by StoneBang at 2021/9/12
 */
object HttpUtil {
    private var mOkHttpClient:OkHttpClient?=null
    fun test1(){
        var retrofit = Retrofit
            .Builder()
            .baseUrl(Constant.BASE_URL)
            .build()
        var res = retrofit.create(ApiService::class.java).test1()
        Log.e("TAG", "getMessage: ${res.request().url().url()}")
        res.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Log.e("TAG", "onResponse: ${String(response.body()!!.bytes())}")
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.e("TAG", "onFailure:${t.message}")
            }
        })

    }

    fun test2(){
        var res = createApi(ApiService::class.java).test2()
        res.enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                com.orhanobut.logger.Logger.e(response.body().toString())
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                Log.e("TAG", "onFailure:${t.message}")
            }
        })

    }

    fun getGoodList(listener:ResponseListener<BaseModel<List<GoodModel>>>){
        var res = createApi(ApiService::class.java).getGoodList()
        res.enqueue(object : Callback<BaseModel<List<GoodModel>>> {
            override fun onResponse(
                call: Call<BaseModel<List<GoodModel>>>,
                response: Response<BaseModel<List<GoodModel>>>
            ) {
                listener.onSuccess(response.body() as BaseModel<List<GoodModel>>)
            }

            override fun onFailure(call: Call<BaseModel<List<GoodModel>>>, t: Throwable) {
                listener.onFail(t.message?:"未知错误")
            }
        })
    }

    fun getManuFactureList(listener:ResponseListener<BaseModel<List<ManuFactureModel>>>){
        var res = createApi(ApiService::class.java).getManufacturerList()
        res.enqueue(object : Callback<BaseModel<List<ManuFactureModel>>> {
            override fun onResponse(
                    call: Call<BaseModel<List<ManuFactureModel>>>,
                    response: Response<BaseModel<List<ManuFactureModel>>>
            ) {
                listener.onSuccess(response.body() as BaseModel<List<ManuFactureModel>>)
            }

            override fun onFailure(call: Call<BaseModel<List<ManuFactureModel>>>, t: Throwable) {
                listener.onFail(t.message?:"未知错误")
            }
        })
    }

    fun <T> createApi(clazz: Class<T>):T{
        var retrofit = Retrofit
                .Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient()!!)
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return retrofit.create(clazz)
    }

    private fun getClient(): OkHttpClient? {
        if(mOkHttpClient==null){
            mOkHttpClient = OkHttpClient
                .Builder()
                .addInterceptor(getInterceptor())
                .readTimeout(50, TimeUnit.SECONDS)//设置超时时间
                .connectTimeout(50, TimeUnit.SECONDS)//设置重连超时时间
                .build()
        }
        return mOkHttpClient;
    }
    private fun getInterceptor():Interceptor{
        HttpLoggingInterceptor.Logger {
            com.orhanobut.logger.Logger.json(it)
        }
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

}
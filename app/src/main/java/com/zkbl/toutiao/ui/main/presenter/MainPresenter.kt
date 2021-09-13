package com.zkbl.toutiao.ui.main.presenter

import android.widget.Toast
import com.zkbl.toutiao.http.HttpUtil
import com.zkbl.toutiao.http.ResponseListener
import com.zkbl.toutiao.mvp.model.BaseModel
import com.zkbl.toutiao.mvp.model.GoodModel
import com.zkbl.toutiao.mvp.model.ManuFactureModel
import com.zkbl.toutiao.mvp.presenter.BasePresenter
import com.zkbl.toutiao.ui.main.view.MainView

/**
 * Create by StoneBang at 2021/9/12
 */
class MainPresenter: BasePresenter<MainView>() {

    fun getGoodList(){
        HttpUtil.getGoodList(object : ResponseListener<BaseModel<List<GoodModel>>> {
            override fun onSuccess(data: BaseModel<List<GoodModel>>) {
                getBaseView()!!.setData(data)
            }
            override fun onFail(message: String) {

                getBaseView()!!.setError(message)
            }
        })
    }
    fun getManuFactureList(){
        HttpUtil.getManuFactureList(object : ResponseListener<BaseModel<List<ManuFactureModel>>> {
            override fun onSuccess(data: BaseModel<List<ManuFactureModel>>) {
                getBaseView()!!.setData(data)
            }
            override fun onFail(message: String) {

                getBaseView()!!.setError(message)
            }
        })
    }
}
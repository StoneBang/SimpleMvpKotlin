package com.zkbl.toutiao.ui.main.presenter

import com.zkbl.toutiao.mvp.presenter.BasePresenter
import com.zkbl.toutiao.ui.main.view.MainView

/**
 * Create by StoneBang at 2021/9/12
 */
class MainPresenter: BasePresenter<MainView>() {

    fun getTest(str:String){
        getBaseView()!!.setData(str)
    }
}
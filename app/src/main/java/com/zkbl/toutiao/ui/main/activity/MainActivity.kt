package com.zkbl.toutiao.ui.main.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.zkbl.toutiao.R
import com.zkbl.toutiao.base.BaseActivity
import com.zkbl.toutiao.ui.main.presenter.MainPresenter
import com.zkbl.toutiao.ui.main.view.MainView

class MainActivity : BaseActivity<MainView,MainPresenter>(),MainView {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
    }

    override fun init() {
        getPresenter()!!.getTest("Hello Word HBB")
    }

    override fun createPresenter(): MainPresenter? = MainPresenter()

    override fun <T> setData(data: T) {
        Log.e("TAG", "setData: "+ data )
    }

    override fun setError(err: String) {

    }
}
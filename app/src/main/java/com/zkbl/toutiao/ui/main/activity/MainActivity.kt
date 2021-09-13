package com.zkbl.toutiao.ui.main.activity

import android.util.Log
import android.widget.Toast
import com.zkbl.toutiao.R
import com.zkbl.toutiao.base.BaseActivity
import com.zkbl.toutiao.mvp.model.BaseModel
import com.zkbl.toutiao.mvp.model.ManuFactureModel
import com.zkbl.toutiao.ui.main.presenter.MainPresenter
import com.zkbl.toutiao.ui.main.view.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainView,MainPresenter>(),MainView {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        getPresenter()!!.getManuFactureList()
    }

    override fun init() {

    }

    override fun createPresenter(): MainPresenter? = MainPresenter()

    override fun <T> setData(data: T) {
       Toast.makeText(this,"拿到数据了",Toast.LENGTH_LONG).show()
        text.setText((data as BaseModel<ManuFactureModel>).toString())
    }

    override fun setError(err: String) {

    }
}
package com.zkbl.toutiao.ui.activity

import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.zkbl.toutiao.R
import com.zkbl.toutiao.base.BaseActivity
import com.zkbl.toutiao.base.BaseModel
import com.zkbl.toutiao.ui.model.ManuFactureModel
import com.zkbl.toutiao.ui.model.viewModel.TestModel
import com.zkbl.toutiao.ui.presenter.MainPresenter
import com.zkbl.toutiao.ui.view.MainView
import com.zkbl.toutiao.utils.Status
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainView,MainPresenter>(),MainView {
    val testModel:TestModel= TestModel()
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
//        getPresenter()!!.getManuFactureList()
        testModel.getUsers().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    println("请求成功")
                    println(it.data.toString())
                }
                Status.ERROR -> {
                    println("请求失败")
                    println(it.message)
                }
                Status.LOADING -> {
                    println("请求中")
                }
            }
        })
    }



    override fun createPresenter(): MainPresenter? = MainPresenter()

    override fun <T> setData(data: T) {
//       Toast.makeText(this,"拿到数据了",Toast.LENGTH_LONG).show()
//        text.setText((data as BaseModel<ManuFactureModel>).toString())
    }

    override fun setError(err: String) {

    }
}
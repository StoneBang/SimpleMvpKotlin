package com.zkbl.toutiao.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zkbl.toutiao.mvp.presenter.BasePresenter
import com.zkbl.toutiao.mvp.view.BaseView

/**
 * Create by StoneBang at 2021/9/12
 */
abstract class BaseActivity<V,P:BasePresenter<V>>:AppCompatActivity() {
    private var mPresenter:P?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        if(mPresenter == null){
            mPresenter = createPresenter()
        }
        mPresenter!!.bindView(this as V)
        init()
        initData()
    }

    abstract fun getLayoutId(): Int

    abstract fun initData()

    abstract fun init()

    abstract fun createPresenter(): P?

    fun getPresenter() = mPresenter

    override fun onDestroy() {
        super.onDestroy()
        mPresenter!!.unBindView()
    }

}
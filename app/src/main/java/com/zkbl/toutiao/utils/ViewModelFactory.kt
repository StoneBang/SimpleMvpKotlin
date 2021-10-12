package com.zkbl.toutiao.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zkbl.toutiao.ui.model.viewModel.TestModel

/**
 * Create by StoneBang at 2021/10/12
 */
class ViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TestModel::class.java)) {
            return TestModel() as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}
package com.zkbl.toutiao.ui.model.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zkbl.toutiao.bean.GithubUser
import com.zkbl.toutiao.http.HttpUtil
import com.zkbl.toutiao.utils.Resource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Create by StoneBang at 2021/10/12
 */
class TestModel:ViewModel() {
    private val user = MutableLiveData<Resource<GithubUser>>()

    init {
        fetchUsers()
    }

      fun fetchUsers() {
        viewModelScope.launch {
            user.postValue(Resource.loading(null))
            HttpUtil.getGithubUserInfo("JakeWharton").catch {
                user.postValue(Resource.error(it.toString(),null))
            }.collect {
                user.postValue(Resource.success(it))
            }
        }
    }


    fun getUsers(): LiveData<Resource<GithubUser>> {
        return user
    }
}
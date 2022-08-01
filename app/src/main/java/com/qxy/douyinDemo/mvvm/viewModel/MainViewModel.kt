package com.qxy.douyinDemo.mvvm.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.qxy.douyinDemo.base.BaseViewModel
import com.qxy.douyinDemo.mvvm.repository.RepositoryImpl
import com.qxy.douyinDemo.bean.LoginInfo
import com.qxy.douyinDemo.network.ApiResult
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : BaseViewModel<RepositoryImpl>(application) {

    var loginResult = MutableLiveData<LoginInfo>()

    fun toLogin(code: String): LiveData<LoginInfo> {
        viewModelScope.launch {

            when (val result = repository?.getToken(code)) {
                is ApiResult.Success -> {
                    loginResult.value = result.data!!
                }
                is ApiResult.Error.ServerError -> {}
                is ApiResult.Error.Exception -> {}
                else -> {}
            }
        }
        return loginResult
    }


}
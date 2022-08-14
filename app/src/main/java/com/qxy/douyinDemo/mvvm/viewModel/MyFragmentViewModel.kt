package com.qxy.douyinDemo.mvvm.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.qxy.douyinDemo.base.BaseViewModel
import com.qxy.douyinDemo.bean.LoginInfo
import com.qxy.douyinDemo.bean.User
import com.qxy.douyinDemo.bean.VideoBean.Vbean
import com.qxy.douyinDemo.mvvm.repository.RepositoryImpl
import com.qxy.douyinDemo.network.ApiResult
import kotlinx.coroutines.launch

class MyFragmentViewModel(application: Application) : BaseViewModel<RepositoryImpl>(application) {
    var loginResult = MutableLiveData<User>()
    var videoResult = MutableLiveData<Vbean>()
    fun ToMessage(assess_token: String,open_id : String): LiveData<User> {
        viewModelScope.launch {

            when (val result = repository?.getMessage(assess_token,open_id)) {
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

    fun ToVideo(oepn_id :String,cursor: String,count : String):LiveData<Vbean>
    {
        viewModelScope.launch {
            when (val result = repository?.getVideo(oepn_id,cursor,count)) {
                is ApiResult.Success -> {
                  videoResult.value = result.data!!
                }
                is ApiResult.Error.ServerError -> {}
                is ApiResult.Error.Exception -> {}
                else -> {}
            }
        }
        return videoResult
    }
}
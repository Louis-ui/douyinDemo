package com.qxy.douyinDemo.mvvm.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.qxy.douyinDemo.base.BaseViewModel
import com.qxy.douyinDemo.bean.User
<<<<<<< HEAD
import com.qxy.douyinDemo.bean.VideoMessage
=======
import com.qxy.douyinDemo.bean.videoBean.Vbean
>>>>>>> 454a94d8e00ec4cafea05ca1629341a197f30c26
import com.qxy.douyinDemo.mvvm.repository.RepositoryImpl
import com.qxy.douyinDemo.network.ApiResult
import kotlinx.coroutines.launch

class MyFragmentViewModel(application: Application) : BaseViewModel<RepositoryImpl>(application) {
    var loginResult = MutableLiveData<User>()
    var videoResult = MutableLiveData<VideoMessage>()
    fun ToMessage(assess_token: String,open_id : String): LiveData<User> {
        viewModelScope.launch {

            when (val result = repository?.getMessage(assess_token,open_id)) {
                is ApiResult.Success -> {
                    Log.d("openId", "userSuccess")
                    loginResult.value = result.data!!
                }
                is ApiResult.Error.ServerError -> {
                    Log.d("openId", "File")
                }
                is ApiResult.Error.Exception -> {
                    Log.d("openId", "File")
                }
                else -> {
                    Log.d("openId", "File3")
                }
            }
        }
        return loginResult
    }

    fun ToVideo(access_token: String,oepn_id :String,cursor: String,count : String):LiveData<VideoMessage>
    {
        viewModelScope.launch {
            when (val result = repository?.getVideo(access_token,oepn_id,cursor,count)) {

                is ApiResult.Success -> {
                    Log.d("openId", "userSuccessV")

                  videoResult.value = result.data!!
                }
                is ApiResult.Error.ServerError -> {
                    Log.d("openId", "File")
                }
                is ApiResult.Error.Exception -> {
                    Log.d("openId", "File")
                }
                else -> {
                    Log.d("openId", "File")
                }
            }
        }
        return videoResult
    }
}
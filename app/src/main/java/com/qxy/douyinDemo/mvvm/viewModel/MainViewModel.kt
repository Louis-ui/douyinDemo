package com.qxy.douyinDemo.mvvm.viewModel

import android.app.Application
import com.qxy.douyinDemo.base.BaseViewModel
import com.qxy.douyinDemo.mvvm.repository.RepositoryImpl

<<<<<<< HEAD
class MainViewModel(application: Application) : BaseViewModel<RepositoryImpl>(application) {

    var loginResult = MutableLiveData<LoginInfo>()
    var clientOauthResult = MutableLiveData<ClientOauthInfo>()

    fun toLogin(code: String): LiveData<LoginInfo> {
        viewModelScope.launch {

            when (val result = repository?.getToken(code)) {
                is ApiResult.Success -> {
                    loginResult.value = result.data!!
                    AppSetting.ACCESS_TOKEN2=result.data.access_token
                    AppSetting.ACCESS_TOKEN3=result.data.access_token
                }
                is ApiResult.Error.ServerError -> {}
                is ApiResult.Error.Exception -> {}
                else -> {}
            }
        }
        return loginResult
    }

    fun getClientToken(): LiveData<ClientOauthInfo> {
        viewModelScope.launch {
            when (val result = repository?.getClientToken()) {
                is ApiResult.Success -> {
                    clientOauthResult.value = result.data!!
                    AppSetting.CLIENT_TOKEN = result.data.access_token
                }
                is ApiResult.Error.ServerError -> {}
                is ApiResult.Error.Exception -> {}
                else -> {}
            }
        }
        return clientOauthResult
    }




}
=======
class MainViewModel(application: Application) : BaseViewModel<RepositoryImpl>(application)
>>>>>>> 454a94d8e00ec4cafea05ca1629341a197f30c26

package com.qxy.douyinDemo.mvvm.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.qxy.douyinDemo.app.AppSetting
import com.qxy.douyinDemo.base.BaseViewModel
import com.qxy.douyinDemo.bean.ClientOauthInfo
import com.qxy.douyinDemo.mvvm.repository.RepositoryImpl
import com.qxy.douyinDemo.bean.LoginInfo
import com.qxy.douyinDemo.network.ApiResult
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : BaseViewModel<RepositoryImpl>(application) {

}
package com.qxy.douyinDemo.UI.Activity

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import com.qxy.douyinDemo.Base.BaseViewModel
import com.qxy.douyinDemo.Base.RepositoryImpl
import com.qxy.douyinDemo.Base.Resource
import com.qxy.douyinDemo.bean.LoginInfo

class MainViewModel(application: Application) : BaseViewModel<RepositoryImpl>(application) {
       suspend fun Tologin(client_secret: String, code: String, grant_type: String, client_key: String) : LiveData<Resource<LoginInfo>>? {
        Log.d("NULL","mAINVIEWMODEL")
        return repository?.getToken(client_secret,code,grant_type,client_key) ?:null
    }
}
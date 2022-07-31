package com.qxy.douyinDemo.Base

import androidx.lifecycle.MutableLiveData
import com.qxy.douyinDemo.bean.LoginInfo
import com.qxy.douyinDemo.bean.User
import com.qxy.douyinDemo.network.ApiResult

class RepositoryImpl : BaseModel(){
    /**
     * getAccessToken
     */
    suspend fun getToken(client_secret: String, code: String, grant_type: String, client_key: String):MutableLiveData<Resource<LoginInfo>>{
        var livedata:MutableLiveData<Resource<LoginInfo>> = MutableLiveData<Resource<LoginInfo>>()
       return Torespond(getBackendService().getAccessToken(client_secret,code,grant_type,client_key),livedata)
    }
}
package com.qxy.douyinDemo.network

import com.qxy.douyinDemo.bean.LoginInfo
import retrofit2.http.GET

interface BackendService {

    @GET("login")
    suspend fun login(): ApiResult<LoginInfo>


}
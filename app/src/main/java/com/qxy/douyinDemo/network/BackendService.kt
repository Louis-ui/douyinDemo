package com.qxy.douyinDemo.network

import com.qxy.douyinDemo.bean.LoginBody
import com.qxy.douyinDemo.bean.LoginInfo
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface BackendService {

    @POST("oauth/access_token")
    suspend fun getAccessToken(@Body loginBody: LoginBody): ApiResult<LoginInfo>


}
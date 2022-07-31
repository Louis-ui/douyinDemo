package com.qxy.douyinDemo.network

import com.qxy.douyinDemo.bean.LoginInfo
import com.qxy.douyinDemo.bean.User
import retrofit2.http.*

interface BackendService {

    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("oauth/access_token/")
    suspend fun getAccessToken(
        @Field("client_secret") client_secret: String,
        @Field("code") code: String,
        @Field("grant_type") grant_type: String,
        @Field("client_key") client_key: String
    ): ApiResult<LoginInfo>


    @POST("oauth/userinfo/")
    suspend fun getUserInfo(@Body map : Map<String , String>  = mutableMapOf()) : ApiResult<User>

}


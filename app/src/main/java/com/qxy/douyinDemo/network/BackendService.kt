package com.qxy.douyinDemo.network

import com.qxy.douyinDemo.bean.LoginInfo
import com.qxy.douyinDemo.bean.User
import com.qxy.douyinDemo.bean.VideoBean.Vbean
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


    /**
     * 获取用户公开信息
     */
    @FormUrlEncoded
    @POST( "/oauth/userinfo/")
    suspend fun getUserMessage(
        @Field("access_token") access_token : String,
        @Field("open_id") open_id :String
    ):ApiResult<User>

    /**
     *video/list/ 获取视频
     */
    @GET("/video/list/")
    suspend fun getVadio(@Query("open_id")open_id : String ,@Query("cursor")cursor : String,@Query("count")count :String) :ApiResult<Vbean>
}


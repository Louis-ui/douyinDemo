package com.qxy.douyinDemo.network

import com.qxy.douyinDemo.bean.*
import com.qxy.douyinDemo.bean.VideoMessage
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
    @POST("/oauth/userinfo/")
    suspend fun getUserMessage(
        @Field("access_token") access_token: String,
        @Field("open_id") open_id: String
    ): ApiResult<User>


    @FormUrlEncoded
    @POST("oauth/refresh_token/")
    suspend fun refreshToken(
        @Field("client_key") client_key: String,
        @Field("grant_type") grant_type: String,
        @Field("refresh_token") refresh_token: String
    ): ApiResult<RefreshTokenInfo>

    @FormUrlEncoded
    @POST("oauth/renew_refresh_token/")
    suspend fun renewRefreshToken(
        @Field("client_key") client_key: String,
        @Field("refresh_token") refresh_token: String
    ): ApiResult<RenewRefreshTokenInfo>

    /**
     *video/list/ 获取视频
     */
    @GET("/video/list/")
    suspend fun getVadio(
        @Header("access-token") access_token: String,
        @Query("open_id") open_id: String,
        @Query("cursor") cursor: String,
        @Query("count") count: String
    ): ApiResult<VideoMessage>

    @POST("oauth/client_token/")
    @FormUrlEncoded
    suspend fun getClientToken(
        @Field("client_key") client_key: String,
        @Field("client_secret") client_secret: String,
        @Field("grant_type") grant_type: String
    ): ApiResult<ClientOauthInfo>

    @GET("discovery/ent/rank/item/")
    suspend fun getRankInfo(
        @Header("access-token") client_token: String,
        @Query("type") type: Int,
        @Query("version") version: Int?
    ): ApiResult<RankInfos>

}


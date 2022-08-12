package com.qxy.douyinDemo.mvvm.repository

import com.qxy.douyinDemo.app.AppSetting
import com.qxy.douyinDemo.base.BaseModel
import com.qxy.douyinDemo.bean.ClientOauthInfo
import com.qxy.douyinDemo.bean.LoginInfo
import com.qxy.douyinDemo.bean.RankInfos
import com.qxy.douyinDemo.network.API
import com.qxy.douyinDemo.network.ApiResult

class RepositoryImpl : BaseModel() {
    /**
     * getAccessToken
     */
    suspend fun getToken(
        code: String
    ): ApiResult<LoginInfo> =
        request {
            API.BACKEND_SERVICE.getAccessToken(
                AppSetting.CLIENT_SECRET,
                code,
                "authorization_code",
                AppSetting.CLIENT_KEY
            )
        }

    suspend fun getClientToken(): ApiResult<ClientOauthInfo> =
        request {
            API.BACKEND_SERVICE.getClientToken(
                AppSetting.CLIENT_KEY,
                AppSetting.CLIENT_SECRET,
                "client_credential"
            )
        }

    suspend fun getRankInfo(type: Int, version: Int?, client_token: String): ApiResult<RankInfos> =
        request {
            API.BACKEND_SERVICE.getRankInfo(
                client_token,
                type,
                version
            )
        }
}
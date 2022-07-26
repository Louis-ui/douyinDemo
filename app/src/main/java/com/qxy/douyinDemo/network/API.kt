package com.qxy.douyinDemo.network

object API {

    @JvmStatic
    val BACKEND_SERVICE: BackendService = BaseAPI.getBackendAPIService(BackendService::class.java)

}
package com.qxy.douyinDemo.network

sealed class ApiResult<T> {
    data class Success<T>(val errorCode: Int, val errorMsg: String, val data: T) : ApiResult<T>()

    /**
     * 网络请求失败
     */
    sealed class Error<T> : ApiResult<T>() {

        /**
         * 服务器内部错误
         */
        data class ServerError<T>(val errorCode: Int, val errorMsg: String) : ApiResult<T>()

        /**
         * 网络请求出现异常
         */
        data class Exception<T> constructor(
            val exception: Throwable
        ) : Error<T>()
    }
}
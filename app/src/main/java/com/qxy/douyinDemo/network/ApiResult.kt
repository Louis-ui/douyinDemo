package com.qxy.douyinDemo.network

sealed class ApiResult<T> {

    data class Success<T>(val data: T?, val message: String) : ApiResult<T>()

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

    override fun toString(): String {
        return when (this) {
            is Success -> {
                this.data.toString()
            }
            is Error.ServerError -> {
                this.errorMsg
            }
            is Error.Exception -> {
                this.exception.toString()
            }
        }
    }
}
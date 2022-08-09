package com.qxy.douyinDemo.network

import okhttp3.Request
import okio.Timeout
import retrofit2.*
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class MyApiResultCallAdapterFactory :
    CallAdapter.Factory() {

    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (getRawType(returnType) != Call::class.java) return null
        check(returnType is ParameterizedType) { "$returnType must be parameterized. Raw types are not supported" }
        val apiResultType = getParameterUpperBound(0, returnType)
        if (getRawType(apiResultType) != ApiResult::class.java) return null
        check(apiResultType is ParameterizedType) { "$apiResultType must be parameterized. Raw types are not supported" }
        val dataType = getParameterUpperBound(0, apiResultType)
        return ApiResultCallAdapter(dataType)
    }
}

class ApiResultCallAdapter(
    private val responseType: Type
) : CallAdapter<Any, Call<Any>> {
    override fun responseType(): Type = responseType

    override fun adapt(call: Call<Any>): Call<Any> {
        return ApiResultCall(call)
    }
}

class ApiResultCall(
    private val delegate: Call<Any>
) : Call<Any> {

    /**
     * KotlinExtensions#await()中会调用enqueue()方法
     */
    override fun enqueue(callback: Callback<Any>) {
        //delegate为OkHttpCall
        delegate.enqueue(object : Callback<Any> {
            //网络请求成功返回，会回调该方法（无论status code是不是200）
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                //无论请求响应成功还是失败都回调Response.success
                if (response.isSuccessful) {
                    val body = response.body()
//                    if (body == null) {
//                        callback.onResponse(
//                            this@ApiResultCall,
//                            Response.success(ApiResult.Error.ServerError<Nothing>(-1, "错误"))
//                        )
//                    } else {
//                        if (body is ApiResult.Success<*>) {
//                            if (body.errorCode == 0) {
//                                callback.onResponse(this@ApiResultCall, Response.success(body))
//                            }
//                        }
//                    }
                    callback.onResponse(this@ApiResultCall, Response.success(body))
                } else {
                    callback.onResponse(
                        this@ApiResultCall,
                        Response.success(ApiResult.Error.ServerError<Nothing>(-1, "错误"))
                    )
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                t.printStackTrace()
                callback.onResponse(
                    this@ApiResultCall,
                    Response.success(ApiResult.Error.Exception<Nothing>(t))
                )
            }
        })
    }


    override fun clone(): Call<Any> = ApiResultCall(delegate.clone())

    override fun execute(): Response<Any> {
        throw UnsupportedOperationException("ApiResultCall does not support synchronous execution")
    }

    override fun isExecuted(): Boolean {
        return delegate.isExecuted
    }

    override fun cancel() {
        delegate.cancel()
    }

    override fun isCanceled(): Boolean {
        return delegate.isCanceled
    }

    override fun request(): Request {
        return delegate.request()
    }

    override fun timeout(): Timeout {
        return delegate.timeout()
    }


}
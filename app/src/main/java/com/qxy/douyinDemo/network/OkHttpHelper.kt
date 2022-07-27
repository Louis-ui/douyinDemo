package com.qxy.douyinDemo.network

import android.util.Log
import com.qxy.douyinDemo.app.AppSetting
import okhttp3.*
import java.util.concurrent.TimeUnit

object OkHttpHelper {

    val JSON = MediaType.parse("application/json; charset=utf-8")

    val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(requestHeaderInterceptor)
            .addInterceptor(responseBodyInterceptor)
            .retryOnConnectionFailure(true)
            .build()
    }


    private val requestHeaderInterceptor: Interceptor by lazy {
        object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val originalRequest = chain.request()
                Log.d("network", "$originalRequest data={${originalRequest.body().toString()}}")
                if (originalRequest.url().host()!!.contentEquals(AppSetting.BACKEND_HOST)) {
                    val requestBuilder = originalRequest.newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .method(originalRequest.method(), originalRequest.body())
                    AppSetting.ACCESS_TOKEN?.let { requestBuilder.addHeader("access-token", it) }
                    return chain.proceed(requestBuilder.build())
                }
                return chain.proceed(originalRequest)
            }
        }
    }

    private val responseBodyInterceptor: Interceptor by lazy {
        Interceptor { chain ->
            val response = chain.proceed(chain.request())
            Log.d("network", "$response data={${response.body()?.string()}}")
            response
        }
    }
}
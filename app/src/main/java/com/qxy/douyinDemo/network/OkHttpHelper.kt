package com.qxy.douyinDemo.network

import android.util.Log
import com.qxy.douyinDemo.app.AppSetting
import okhttp3.*
import okio.Buffer
import java.util.concurrent.TimeUnit

object OkHttpHelper {

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
                Log.d("network", "$originalRequest data={${originalRequest.body()?.string()}}")
                if (originalRequest.url().host()!!.contentEquals(AppSetting.BACKEND_HOST)) {
                    val requestBuilder = originalRequest.newBuilder()
                    if (originalRequest.url().toString().contains("access_token")) {
                        requestBuilder.addHeader(
                            "Content-Type", "application/x-www-form-urlencoded"
                        )
                    } else {
                        requestBuilder.addHeader(
                            "Content-Type", "application/json"
                        )
                    }
                    requestBuilder.method(originalRequest.method(), originalRequest.body())

                    AppSetting.ACCESS_TOKEN?.let {
                        requestBuilder.addHeader(
                            "access-token",
                            it
                        )
                    }
                    val request = requestBuilder.build()
                    return chain.proceed(request)
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

    fun RequestBody.string(): String {
        val buffer = Buffer()
        writeTo(buffer)
        return buffer.readUtf8()
    }

}
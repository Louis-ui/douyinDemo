package com.qxy.douyinDemo.network

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object OkHttpHelper {

    val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
//            .addInterceptor()
            .retryOnConnectionFailure(true)
            .build()
    }


}
package com.qxy.douyinDemo.network

import com.qxy.douyinDemo.app.AppSetting
import retrofit2.Converter
import retrofit2.Retrofit

object BaseAPI {
    private fun getRetrofit(
        api: String,
        converterFactory: Converter.Factory,
        callAdapterFactory: MyApiResultCallAdapterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(callAdapterFactory)
            .client(OkHttpHelper.okHttpClient)
            .baseUrl(api)
            .build()
    }


    private val backendAPIRetrofit: Retrofit by lazy {
        getRetrofit(
            AppSetting.BACKEND_BASE_URL,
            CustomGsonConverterFactory.create(),
            MyApiResultCallAdapterFactory()
        )
    }

    fun <T> getBackendAPIService(service: Class<T>): T {
        return backendAPIRetrofit.create(service)
    }
}
package com.qxy.douyinDemo.network

import com.google.gson.GsonBuilder
import com.qxy.douyinDemo.app.AppSetting
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
            GsonConverterFactory.create(
                GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                    .create()
            ),
            MyApiResultCallAdapterFactory()
        )
    }

    fun <T> getBackendAPIService(service: Class<T>): T {
        return backendAPIRetrofit.create(service)
    }
}
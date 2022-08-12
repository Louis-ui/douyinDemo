package com.qxy.douyinDemo.base

import android.util.Log
import com.qxy.douyinDemo.network.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseModel {

    suspend fun <T : Any> request(call: suspend () -> ApiResult<T>): ApiResult<T> {
        return withContext(Dispatchers.IO) {
            call.invoke()
        }.apply { Log.d("Model", "request: $this") }
    }

}
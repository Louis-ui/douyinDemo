package com.qxy.douyinDemo.base

import android.util.Log
import com.qxy.douyinDemo.network.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * A base Model class for all in the project.
 * @author louis-ui
 */
abstract class BaseModel {

    /**
     * This method is used to send a quest and get the result.
     * @param T Data class
     * @return Results of encapsulated data request
     */
    suspend fun <T : Any> request(call: suspend () -> ApiResult<T>): ApiResult<T> {
        return withContext(Dispatchers.IO) {
            call.invoke()
        }.apply {
            Log.d("Model", "request: $this")
        }
    }
}
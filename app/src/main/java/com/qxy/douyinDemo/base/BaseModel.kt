package com.qxy.douyinDemo.base

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.qxy.douyinDemo.network.API
import com.qxy.douyinDemo.network.ApiResult
import com.qxy.douyinDemo.network.BackendService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseModel {
    public fun getBackendService(): BackendService {
        return API.BACKEND_SERVICE
    }

    suspend fun <T : Any> request(call: suspend () -> ApiResult<T>): ApiResult<T> {
        return withContext(Dispatchers.IO) {
            call.invoke()
        }.apply { Log.d("Model", "request: $this") }
    }

    public fun <T> toRespond(
        apiResult: ApiResult<T>,
        liveData: MutableLiveData<Resource<T>>
    ): MutableLiveData<Resource<T>> {
        when (apiResult) {
            is ApiResult.Success -> liveData.postValue(Resource.SuccessApi(apiResult))
            is ApiResult.Error.ServerError -> liveData.postValue(Resource.Error1Api(apiResult))
            is ApiResult.Error.Exception -> liveData.postValue(Resource.Error2Api(apiResult))
            else -> {

            }
        }
        return liveData
    }
}
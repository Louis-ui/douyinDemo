package com.qxy.douyinDemo.Base

import androidx.lifecycle.MutableLiveData
import com.qxy.douyinDemo.network.API
import com.qxy.douyinDemo.network.ApiResult
import com.qxy.douyinDemo.network.BackendService

abstract class BaseModel {
    public fun getBackendService(): BackendService{
        return API.BACKEND_SERVICE
    }
    public fun<T> Torespond(apiResult: ApiResult<T>,liveData: MutableLiveData<Resource<T>>):MutableLiveData<Resource<T>>{
        when(apiResult)
        {
            is ApiResult.Success->liveData.postValue(Resource.SuccessApi(apiResult))
            is ApiResult.Error.ServerError->liveData.postValue(Resource.Error1Api(apiResult))
            is ApiResult.Error.Exception->liveData.postValue(Resource.Error2Api(apiResult))
            else->{

            }
        }
        return liveData
    }
}
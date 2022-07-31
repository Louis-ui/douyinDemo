package com.qxy.douyinDemo.Base

import android.util.Log
import com.qxy.douyinDemo.network.ApiResult

class Resource<T> {
    var data: T?=null
    var message: String = ""
    var STAT : Int = 0
    var errorCode: Int = 0
    var errorMsg: String?=null
    companion object{
       const val SUCCESS : Int=1//成功
       const val ERROR1 : Int=2//错误一
       const val ERROR2 :Int=3//错误二

       fun<S> SuccessApi(apiResult: ApiResult<S>):Resource<S>{
           apiResult as ApiResult.Success
           return Resource(apiResult.data,apiResult.message, SUCCESS)
       }
        fun<S> Error1Api(apiResult: ApiResult<S>):Resource<S>{
            apiResult as ApiResult.Error.ServerError
            return Resource(ERROR1,apiResult.errorCode,apiResult.errorMsg)
        }
        fun<S> Error2Api(apiResult: ApiResult<S>):Resource<S>{
            apiResult as ApiResult.Error.Exception
            return Resource(ERROR2)
        }
    }




    constructor()
    constructor(data: T?, message: String, STAT: Int) {
        this.data = data
        this.message = message
        this.STAT = STAT
    }

    constructor(STAT: Int, errorCode: Int, errorMsg: String?) {
        this.STAT = STAT
        this.errorCode = errorCode
        this.errorMsg = errorMsg
    }

    constructor(STAT: Int) {
        this.STAT = STAT
    }


    fun handler(callback: callback){
        oncallback(callback)
    }

    fun oncallback(callback: callback){
        when(STAT)
        {
            1->callback.success()
            2->callback.error1()
            3->callback.error2()
            else->{

            }

        }
    }


}
package com.qxy.douyinDemo.Base

import android.util.Log
import com.qxy.douyinDemo.network.ApiResult

abstract  class callback{
    abstract fun success()
    fun error1()
    {
        Log.d("auth", "onCreate: fail ServerError")
    }
    fun error2()
    {
        Log.d("auth", "onCreate: fail Exception")
    }
}
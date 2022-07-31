package com.qxy.douyinDemo.base

import android.util.Log

abstract  class Callback{
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
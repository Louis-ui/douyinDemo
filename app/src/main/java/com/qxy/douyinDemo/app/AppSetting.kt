package com.qxy.douyinDemo.app

import android.annotation.SuppressLint
import android.content.Context


@SuppressLint("StaticFieldLeak")
object AppSetting {

    const val BACKEND_BASE_URL = "https://open.douyin.com/"

    const val BACKEND_HOST = "open.douyin.com"

    const val CLIENT_KEY = "awu95tytw3o80nuh"

    const val CLIENT_SECRET = "8a861d324c2ce139b40694b0a37f27ad"

    var ACCESS_TOKEN: String? = null

    var REFRESH_TOKEN: String? = null

    var OPEN_ID: String? = null

    var context: Context? = null

    var CLIENT_TOKEN: String? = null

    /**
     * 自己加的
     */
    var ACCESS_TOKEN2 :String? =null
    var ACCESS_TOKEN3 :String?=null
}
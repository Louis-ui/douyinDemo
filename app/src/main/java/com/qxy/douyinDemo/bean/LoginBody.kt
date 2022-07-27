package com.qxy.douyinDemo.bean

data class LoginBody(
    val client_secret: String,
    val code: String,
    val grant_type: String,
    val client_key: String

)

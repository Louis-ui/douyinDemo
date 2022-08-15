package com.qxy.douyinDemo.bean

//{
//    "data": {
//        "description": "",
//        "error_code": "0",
//        "expires_in": "86400",
//        "refresh_token": "refresh_token"
//    },
//    "message": "success"
//}

data class RenewRefreshTokenInfo(
    val data: String,
    val description: String,
    val error_code: String,
    val expires_in: String,
    val refresh_token: String,
    val message: String)

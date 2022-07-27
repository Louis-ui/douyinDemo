package com.qxy.douyinDemo.bean

import java.io.Serializable


/**
 * {
"data": {
"access_token": "access_token",
"description": "",
"error_code": "0",
"expires_in": "86400",
"open_id": "aaa-bbb-ccc",
"refresh_expires_in": "86400",
"refresh_token": "refresh_token",
"scope": "user_info"
},
"message": "<nil>"
}
 */

data class LoginInfo(
    val access_token: String,
    val description: String,
    val error_code: String,
    val expires_in: String,
    val open_id: String,
    val refresh_expires_in: String,
    val refresh_token: String,
    val scope: String
) : Serializable

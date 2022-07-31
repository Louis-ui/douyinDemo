package com.qxy.douyinDemo.bean

import java.io.Serializable


/**
 * {"data":{"access_token":"act.1ad9da634b69dda95eabe40508be4d23lWMfDq7JZYaoLoYMpZ3vVq4l5wjr",
 * "captcha":"",
 * "desc_url":"",
 * "description":"",
 * "error_code":0,
 * "expires_in":1296000,
 * "log_id":"202207281314010102020910862009D3FA",
 * "open_id":"_000MTMjsr8Zy4_37r-hPOx363bNbJ3Uelpl",
 * "refresh_expires_in":2592000,
 * "refresh_token":"rft.a3820e290a4c4abbe1a6ae5e632eefedEAw3irGMcRbB53tzAZ8pBGZtu82H",
 * "scope":"user_info"
 * },
 * "message":"success"}
 */

data class LoginInfo(
    val access_token: String?,
    val captcha: String?,
    val desc_url: String?,
    val description: String?,
    val error_code: String?,
    val expires_in: String?,
    val log_id: String?,
    val open_id: String?,
    val refresh_expires_in: String?,
    val refresh_token: String?,
    val scope: String?
) : Serializable

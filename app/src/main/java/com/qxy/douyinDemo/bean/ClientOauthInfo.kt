package com.qxy.douyinDemo.bean

import java.io.Serializable

/**
 * {
"data": {
"access_token": "clt.03ea55535a5913101ad26b2686f2fb55hs8jtIbDycPb4tac1pUVwn0YGMD2",
"captcha": "",
"desc_url": "",
"description": "",
"error_code": 0,
"expires_in": 7200,
"log_id": "202208120119180102121400270423A6E9"
},
"message": "success"
}
 */

class ClientOauthInfo(
    val access_token: String? ,
    val captcha: String? ,
    val desc_url: String? ,
    val description: String? ,
    val error_code: String? ,
    val expires_in: String? ,
    val log_id: String?
): Serializable { }
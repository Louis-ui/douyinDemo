package com.qxy.douyinDemo.bean

//{
//    "data": {
//        "description": "access_token过期,请刷新或重新授权",
//        "error_code": 2190008
//    },
//    "extra": {
//        "description": "access_token过期,请刷新或重新授权",
//        "error_code": 2190008,
//        "logid": "202208121428010102091461593C0FFA9B",
//        "now": 1660285681707,
//        "sub_description": "",
//        "sub_error_code": 0
//    }
//}

data class Extra(
    var description: String,
    var error_code: String,
    var logid: String,
    var now: String,
    var sub_description: String,
    var sub_error_code0: String)

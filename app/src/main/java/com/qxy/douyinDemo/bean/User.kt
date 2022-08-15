package com.qxy.douyinDemo.bean

//{
//    "data": {
//        "avatar": "https://example.com/x.jpeg",
//        "city": "上海",
//        "country": "中国",
//        "description": "",
//        "e_account_role": "<nil>",
//        "error_code": "0",
//        "gender": "<nil>",
//        "nickname": "张伟",
//        "open_id": "0da22181-d833-447f-995f-1beefea5bef3",
//        "province": "上海",
//        "union_id": "1ad4e099-4a0c-47d1-a410-bffb4f2f64a4"
//    }
//}

data class User(
    val avatar: String,
    val city: String,
    val country: String,
    val description: String,
    val e_account_role: String,
    val error_code: String,
    val gender: String,
    val nickname: String,
    val open_id: String,
    val province: String,
    val union_id: String) {
    override fun toString(): String {
        return "User(avatar='$avatar', city='$city', country='$country', description='$description', e_account_role='$e_account_role', error_code='$error_code', gender='$gender', nickname='$nickname', open_id='$open_id', province='$province', union_id='$union_id')"
    }
}

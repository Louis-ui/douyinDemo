package com.qxy.douyinDemo.bean.followBean

class FollowInfos(
    val description: String,
    val error_code: String, val cursor: Int, val has_more: Boolean, var list: List<FInfo>
) {
    override fun toString(): String {
        return "FollowInfos(description='$description', error_code='$error_code', cursor='$cursor', has_more='$has_more', list='$list')"
    }
}

class FInfo(
    val union_id: String,
    val nickname: String,
    val avatar: String,
    val city: String,
    val province: String,
    val country: String,
    val gender: String,
    val open_id: String,
) {
    override fun toString(): String {
        return "FInfo(union_id='$union_id', nickname='$nickname', avatar='$avatar', city='$city', province='$province', country='$country', gender='$gender', open_id='$open_id')"
    }
}

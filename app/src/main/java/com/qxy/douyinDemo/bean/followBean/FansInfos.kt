package com.qxy.douyinDemo.bean.followBean

class FansInfos(
    val description: String,
    val error_code: String,
    val cursor: Int,
    val has_more: Boolean,
    var list: List<FInfo>,
    val total: Int
) {
    override fun toString(): String {
        return "FansInfos(description='$description', error_code='$error_code', cursor='$cursor', has_more='$has_more', list='$list', total='$total')"
    }
}

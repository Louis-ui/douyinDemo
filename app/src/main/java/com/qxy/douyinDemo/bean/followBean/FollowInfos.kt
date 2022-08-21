package com.qxy.douyinDemo.bean.followBean

import com.qxy.douyinDemo.bean.Extra
import com.qxy.douyinDemo.bean.User

class FollowInfos(val cursor: Int, val has_more: Boolean, var list: List<User>) {
    override fun toString(): String {
        return "FollowInfos(cursor='$cursor', has_more='$has_more', items='$list')"
    }
}

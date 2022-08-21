package com.qxy.douyinDemo.bean.followBean

import com.qxy.douyinDemo.bean.Extra
import com.qxy.douyinDemo.bean.User

class FansInfos(val cursor: Int, val has_more: Boolean, var list: List<User>, val total: Int) {
    override fun toString(): String {
        return "FansInfos(cursor='$cursor', has_more='$has_more', items='$list', total='$total')"
    }
}

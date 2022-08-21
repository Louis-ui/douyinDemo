package com.qxy.douyinDemo.bean.followBean

import com.qxy.douyinDemo.bean.Extra
import com.qxy.douyinDemo.bean.User

data class FollowInfos(val extra: Extra, var data: FollowData)

data class FollowData(val cursor: Int, val has_more: Boolean, var list: List<User>)

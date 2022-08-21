package com.qxy.douyinDemo.bean.followBean

import com.qxy.douyinDemo.bean.Extra
import com.qxy.douyinDemo.bean.User

data class FansInfos(val extra: Extra, var data: FansData)

data class FansData(val cursor: Int, val has_more: Boolean, var list: List<User>, val total: Int)

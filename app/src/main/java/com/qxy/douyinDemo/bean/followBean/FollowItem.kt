package com.qxy.douyinDemo.bean.followBean

import android.net.Uri

class FollowItem(
    var userPost: Uri?,
    val username: String,
    val country: String,
    val province: String,
    val city: String,
    val gender: String,
    val followType: Int
) {
    object type {
        val FOLLOW_TYPE = 0
        val FANS_TYPE = 1
    }
}
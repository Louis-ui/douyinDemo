package com.qxy.douyinDemo.bean

class FollowItem(
    val username: String,
    val country: String,
    val province: String,
    val city: String,
    val gender: String,
    val movieType: Int
) {
    object type {
        val FOLLOW_TYPE = 0
        val FANS_TYPE = 1
    }
}
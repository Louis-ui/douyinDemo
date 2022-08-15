package com.qxy.douyinDemo.bean.videoBean

import kotlin.collections.List

data class Data (
    val error_code : Int,
    val description: String?,
    val has_more :Boolean,
    val list: List<com.qxy.douyinDemo.bean.videoBean.List>?,
    val cursor :Int= 0)
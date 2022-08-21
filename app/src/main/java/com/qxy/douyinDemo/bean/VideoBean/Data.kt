package com.qxy.douyinDemo.bean.VideoBean

import java.io.Serializable
import kotlin.collections.List

 data class Data(
 val error_code: Int,
 val description: String,
 val has_more: Boolean,
 val list: List<com.qxy.douyinDemo.bean.VideoBean.List>,
 val cursor: Long
): Serializable{

}
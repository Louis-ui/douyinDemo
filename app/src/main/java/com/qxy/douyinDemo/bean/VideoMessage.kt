package com.qxy.douyinDemo.bean

import java.io.Serializable
import kotlin.collections.List

 data class VideoMessage(
  val error_code: Int,
  val description: String,
  val has_more: Boolean,
  val list: List<com.qxy.douyinDemo.bean.List>,
  val cursor: Long
): Serializable{

}
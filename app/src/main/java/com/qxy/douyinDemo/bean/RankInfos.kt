package com.qxy.douyinDemo.bean

import java.io.Serializable

class RankInfos(
    val active_time : String,
    val description : String,
    val error_code : String,
    var list: List<RankInfo>
) : Serializable {
    override fun toString(): String {
        return "RankInfos(active_time='$active_time', description='$description', error_code='$error_code', items=$list)"
    }
}

class RankInfo(
    var actors: List<String> ,
    var maoyan_id: String? ,
    var name: String? ,
    var name_en: String? ,
    var areas: List<String> ,
    var directors: List<String> ,
    var discussion_hot: String? ,
    var id: String? ,
    var search_hot: String? ,
    var influence_hot: String? ,
    var release_data: String? ,
    var topic_hot: String? ,
    var type: String? ,
    var hot: String? ,
    var poster: String? ,
    var tags: List<String> ,
    var log_id: String? ,
    var now: String? ,
    var sub_description: String? ,
    var sub_error_code: String?
) : Serializable {}
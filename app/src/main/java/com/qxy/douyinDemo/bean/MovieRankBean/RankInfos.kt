package com.qxy.douyinDemo.bean

import java.io.Serializable

class RankInfos(
    val active_time : String,
    val description : String,
    val error_code : String,
    var list: List<RankInfo>
) : Serializable {
    override fun toString(): String {
        return "RankInfos(active_time='$active_time', description='$description', error_code='$error_code', items=${list.toString()})"
    }
}

class RankInfo(
    var actors: List<String>,
    var maoyan_id: String?,
    var name: String?,
    var name_en: String?,
    var areas: List<String>,
    var directors: List<String>,
    var discussion_hot: String?,
    var id: String?,
    var search_hot: String?,
    var influence_hot: String?,
    var release_date: String?,
    var topic_hot: String?,
    var type: String?,
    var hot: String?,
    var poster: String?,
    var tags: List<String>,
    var log_id: String?,
    var now: String?,
    var sub_description: String?,
    var sub_error_code: String?
) : Serializable {
    override fun toString(): String {
        return "RankInfo(actors=$actors,\n maoyan_id=$maoyan_id,\n name=$name,\n name_en=$name_en,\n areas=$areas,\n directors=$directors,\n discussion_hot=$discussion_hot,\n id=$id,\n search_hot=$search_hot,\n influence_hot=$influence_hot,\n release_data=$release_date,\n topic_hot=$topic_hot,\n type=$type,\n hot=$hot,\n poster=$poster,\n tags=$tags,\n log_id=$log_id,\n now=$now,\n sub_description=$sub_description,\n sub_error_code=$sub_error_code)"
    }
}
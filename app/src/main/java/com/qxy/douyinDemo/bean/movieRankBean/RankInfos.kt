package com.qxy.douyinDemo.bean

import androidx.room.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable

class RankInfos(
    val active_time: String,
    val description: String,
    val error_code: String,
    var list: List<RankInfo>
) : Serializable {
    override fun toString(): String {
        return "RankInfos(active_time='$active_time', description='$description', error_code='$error_code', items=${list.toString()})"
    }
}

@Entity
@TypeConverters(StringListConverters::class)
class RankInfo(
    @PrimaryKey(autoGenerate = true) val uid: Int?,
    @ColumnInfo(name = "actors") var actors: List<String>?,
    @ColumnInfo(name = "maoyan_id") var maoyan_id: String?,
    @ColumnInfo(name = "name") var name: String?,
    @ColumnInfo(name = "name_en") var name_en: String?,
    @ColumnInfo(name = "areas") var areas: List<String>?,
    @ColumnInfo(name = "directors") var directors: List<String>?,
    @ColumnInfo(name = "discussion_hot") var discussion_hot: String?,
    @ColumnInfo(name = "id") var id: String?,
    @ColumnInfo(name = "search_hot") var search_hot: String?,
    @ColumnInfo(name = "influence_hot") var influence_hot: String?,
    @ColumnInfo(name = "release_date") var release_date: String?,
    @ColumnInfo(name = "topic_hot") var topic_hot: String?,
    @ColumnInfo(name = "type") var type: String?,
    @ColumnInfo(name = "hot") var hot: String?,
    @ColumnInfo(name = "poster") var poster: String?,
    @ColumnInfo(name = "tags") var tags: List<String>?,
    @ColumnInfo(name = "log_id") var log_id: String?,
    @ColumnInfo(name = "now") var now: String?,
    @ColumnInfo(name = "sub_description") var sub_description: String?,
    @ColumnInfo(name = "sub_error_code") var sub_error_code: String?
) : Serializable {
    override fun toString(): String {
        return "RankInfo(" +
                "actors=$actors,\n " +
                "maoyan_id=$maoyan_id,\n " +
                "name=$name,\n " +
                "name_en=$name_en,\n " +
                "areas=$areas,\n " +
                "directors=$directors,\n " +
                "discussion_hot=$discussion_hot,\n " +
                "id=$id,\n " +
                "search_hot=$search_hot,\n " +
                "influence_hot=$influence_hot,\n " +
                "release_data=$release_date,\n " +
                "topic_hot=$topic_hot,\n " +
                "type=$type,\n " +
                "hot=$hot,\n " +
                "poster=$poster,\n " +
                "tags=$tags,\n " +
                "log_id=$log_id,\n " +
                "now=$now,\n " +
                "sub_description=$sub_description,\n " +
                "sub_error_code=$sub_error_code)"
    }
}

class StringListConverters {
    @TypeConverter
    fun stringToObject(value: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun objectToString(list: List<String>?): String {
        val gson = Gson()
        if (list == null) {
            return gson.toJson(mutableListOf<String>())
        }
        return gson.toJson(list)
    }
}


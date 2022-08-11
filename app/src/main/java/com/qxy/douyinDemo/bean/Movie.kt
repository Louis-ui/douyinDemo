package com.qxy.douyinDemo.bean

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @PrimaryKey(autoGenerate = true) val uid: Int?,
    val name: String
)

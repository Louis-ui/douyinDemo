package com.qxy.douyinDemo.mvvm.dao

import androidx.room.Dao
import com.qxy.douyinDemo.base.BaseDao
import com.qxy.douyinDemo.bean.Movie

@Dao
abstract class MovieDao : BaseDao<Movie>() {
}
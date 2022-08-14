package com.qxy.douyinDemo.mvvm.dao

import androidx.room.Dao
import com.qxy.douyinDemo.base.BaseDao
import com.qxy.douyinDemo.bean.RankInfo

@Dao
abstract class MovieDao : BaseDao<RankInfo>() {

}
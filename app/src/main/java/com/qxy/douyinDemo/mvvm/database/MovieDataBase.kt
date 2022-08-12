package com.qxy.douyinDemo.mvvm.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.qxy.douyinDemo.bean.Movie
import com.qxy.douyinDemo.mvvm.dao.MovieDao

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MovieDataBase : RoomDatabase() {

    abstract fun getMovie(): MovieDao

    companion object {
        private const val DB_NAME = "MovieDatabase.db"

        @Volatile
        private var movieDatabase: MovieDataBase? = null

        @Synchronized
        fun getInstance(context: Context): MovieDataBase {
            if (movieDatabase == null) {
                movieDatabase = create(context)
            }
            return movieDatabase!!
        }

        private fun create(context: Context): MovieDataBase {
            return Room.databaseBuilder(context, MovieDataBase::class.java, DB_NAME)
                .build()
        }
    }

}
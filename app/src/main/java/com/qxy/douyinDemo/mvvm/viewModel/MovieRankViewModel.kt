package com.qxy.douyinDemo.mvvm.viewModel

import android.app.Application
import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.qxy.douyinDemo.app.AppSetting
import com.qxy.douyinDemo.base.BaseViewModel
import com.qxy.douyinDemo.bean.MovieRankBean.MovieItem
import com.qxy.douyinDemo.bean.RankInfo
import com.qxy.douyinDemo.bean.RankInfos
import com.qxy.douyinDemo.mvvm.database.MovieDataBase
import com.qxy.douyinDemo.mvvm.repository.RepositoryImpl
import com.qxy.douyinDemo.network.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieRankViewModel(application: Application) : BaseViewModel<RepositoryImpl>(application) {
    var movieRank = MutableLiveData<RankInfos>()
    var realMovieRank: LiveData<ArrayList<MovieItem>> = Transformations.map(movieRank) { movies ->
        val tempList = ArrayList<MovieItem>()
        for (i in 0 until movies.list.size) {
            val tempMovieItem = movies.list[i]

            tempList.add(
                MovieItem(
                    Uri.parse(tempMovieItem.poster),
                    tempMovieItem.name.toString(),
                    tempMovieItem.name_en.toString(),
                    tempMovieItem.hot.toString(),
                    tempMovieItem.release_date.toString(),
                    MovieItem.type.CINEMA_MOVIE_TYPE
                )
            )
        }
        tempList
    }

    fun getMovieRankFromBackEnd(): LiveData<RankInfos> {
        viewModelScope.launch {
            when (val result =
                AppSetting.CLIENT_TOKEN?.let { repository?.getRankInfo(1, null, it) }) {
                is ApiResult.Success -> {
                    movieRank.value = result.data!!
                    deleteAllMovieRankData()
                    saveMovieRankData(result.data)
                }
                is ApiResult.Error.ServerError -> {
                    getMovieRankFromDataBase()
                }
                is ApiResult.Error.Exception -> {
                    getMovieRankFromDataBase()
                }
                else -> {}
            }
        }
        return movieRank
    }

    private fun saveMovieRankData(rankInfos: RankInfos) {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                for (i in rankInfos.list) {
                    MovieDataBase.getInstance(AppSetting.context!!).getMovie().insert(i)
                }
            }
        }
    }

    private fun getMovieRankFromDataBase() {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                MovieDataBase.getInstance(AppSetting.context!!).getMovie().findAll()
                    ?.let { movieRank.value?.list = it }
            }
        }
    }
    private fun deleteAllMovieRankData(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                MovieDataBase.getInstance(AppSetting.context!!).getMovie().deleteAll()
            }
        }
    }
}
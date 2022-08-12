package com.qxy.douyinDemo.mvvm.viewModel

import android.app.Application
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.qxy.douyinDemo.app.AppSetting
import com.qxy.douyinDemo.base.BaseViewModel
import com.qxy.douyinDemo.bean.MovieItem
import com.qxy.douyinDemo.bean.RankInfo
import com.qxy.douyinDemo.bean.RankInfos
import com.qxy.douyinDemo.mvvm.repository.RepositoryImpl
import com.qxy.douyinDemo.network.ApiResult
import kotlinx.coroutines.launch

class MovieRankViewModel(application: Application): BaseViewModel<RepositoryImpl>(application) {
    var movieRank = MutableLiveData<RankInfos>()
    var realMovieRank: LiveData<ArrayList<MovieItem>> = Transformations.map(movieRank) { movies ->
        val tempList = ArrayList<MovieItem>()
        for(i in 0 until movies.items.size) {
            val tempMovieItem = movies.items[i]

            tempList.add(MovieItem(
                Uri.parse(tempMovieItem.poster),
                tempMovieItem.name.toString(),
                tempMovieItem.name_en.toString(),
                tempMovieItem.hot.toString(),
                tempMovieItem.release_data.toString(),
                MovieItem.type.CINEMA_MOVIE_TYPE
            ))
        }
        tempList
    }

    fun getMovieRank(): LiveData<RankInfos> {
        viewModelScope.launch {
            when (val result =
                AppSetting.CLIENT_TOKEN?.let { repository?.getRankInfo(1, null, it) }) {
                    is ApiResult.Success -> {
                        movieRank.value = result.data!!
                    }
                    is ApiResult.Error.ServerError -> {}
                    is ApiResult.Error.Exception -> {}
                    else -> {}
            }
        }
        return movieRank
    }
}
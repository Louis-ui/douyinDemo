package com.qxy.douyinDemo.UI.movieRank

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.qxy.douyinDemo.R
import com.qxy.douyinDemo.UI.MovieRank.MovieItemDecoration
import com.qxy.douyinDemo.base.BaseFragment
import com.qxy.douyinDemo.bean.MovieItem
import com.qxy.douyinDemo.databinding.FragmentMovieBinding
import com.qxy.douyinDemo.mvvm.repository.RepositoryImpl
import com.qxy.douyinDemo.mvvm.viewModel.MovieRankViewModel
import com.qxy.douyinDemo.ui.movieRank.MovieItemAdapter

class MovieFragment(val movieTypeCreate: Int): BaseFragment<RepositoryImpl, MovieRankViewModel, FragmentMovieBinding>() {
    private val movieItemList = ArrayList<MovieItem>()

    override fun getContentViewId(): Int = R.layout.fragment_movie

    override fun processLogic(savedInstanceState: Bundle?) {
        Log.d("MovieFragment", "processLogic called!")
    }

    override fun setListener() {
        val layoutManager = LinearLayoutManager(context)
        val adapter = MovieItemAdapter(movieItemList, movieTypeCreate)
        initData()
        binding.moviesList.apply {
            this.layoutManager = layoutManager
            this.addItemDecoration(MovieItemDecoration())
            this.adapter = adapter
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
        }
    }

    fun initData() {
        when (movieTypeCreate) {
            MovieItem.type.CINEMA_MOVIE_TYPE -> {
                for (i in 0..20) {
                    movieItemList.add(
                        MovieItem(
                            "cinema title$i", "subtitle1: $i",
                            "subtitle2: $i", "subtitle3: $i",
                            MovieItem.type.CINEMA_MOVIE_TYPE
                        )
                    )
                }
            }

            MovieItem.type.WEB_MOVIE_TYPE -> {
                for (i in 0..20) {
                    movieItemList.add(
                        MovieItem(
                            "web title$i", "subtitle1: $i",
                            "subtitle2: $i", "subtitle3: $i",
                            MovieItem.type.WEB_MOVIE_TYPE
                        )
                    )
                }
            }
        }
    }

}
package com.qxy.douyinDemo.ui.movieRank

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.qxy.douyinDemo.R
import com.qxy.douyinDemo.base.BaseFragment
import com.qxy.douyinDemo.bean.MovieRankBean.MovieItem
import com.qxy.douyinDemo.databinding.FragmentMovieBinding
import com.qxy.douyinDemo.mvvm.repository.RepositoryImpl
import com.qxy.douyinDemo.mvvm.viewModel.MovieRankViewModel

class MovieFragment(private val movieTypeCreate: Int) :
    BaseFragment<RepositoryImpl, MovieRankViewModel, FragmentMovieBinding>() {
    private val movieItemList = ArrayList<MovieItem>()

    override fun getContentViewId(): Int = R.layout.fragment_movie

    override fun processLogic(savedInstanceState: Bundle?) {
        Log.d("MovieFragment", "processLogic called!")
    }

    override fun setListener() {
        val layoutManager = LinearLayoutManager(context)
//        val adapter = MovieItemAdapter(movieTypeCreate, movieItemList)
        var adapter = MovieItemAdapter(movieItemList, movieTypeCreate, requireContext())
        initData(adapter)
        binding.moviesList.apply {
            this.layoutManager = layoutManager
            this.addItemDecoration(
                MovieItemDecoration(
                    requireActivity(),
                    LinearLayoutManager.VERTICAL,
                    R.layout.item_top_decor_movie
                )
            )
            this.adapter = adapter
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
        }
    }

    fun initData(adapter: MovieItemAdapter) {
        when (movieTypeCreate) {
            MovieItem.type.CINEMA_MOVIE_TYPE -> {
                mViewModel?.getMovieRank()
                mViewModel?.realMovieRank?.observe(this) {
                    for (i in 0 until it.size) {
                        movieItemList.add(it[i])
                        Log.d("realMovieRank_data", "initData: ${it[i].movieTitle}")
                    }
                    adapter.notifyDataSetChanged()
                }
//                mViewModel?.movieRank?.observe(this) {
//                    Log.d("movieRank_data", "initData: ${it.toString()}")
//                }
            }

            MovieItem.type.WEB_MOVIE_TYPE -> {
                for (i in 0..20) {
                    movieItemList.add(
                        MovieItem(
                            null, "title: $i","subtitle1: $i",
                            "subtitle2: $i", "subtitle3: $i",
                            MovieItem.type.WEB_MOVIE_TYPE
                        )
                    )
                }
            }
        }
    }

}
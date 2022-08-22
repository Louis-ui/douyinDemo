
package com.qxy.douyinDemo.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.qxy.douyinDemo.R
import com.qxy.douyinDemo.ui.listAdapter.MovieItemDecoration
import com.qxy.douyinDemo.base.BaseFragment
import com.qxy.douyinDemo.bean.movieRankBean.MovieItem
import com.qxy.douyinDemo.databinding.FragmentMovieBinding
import com.qxy.douyinDemo.mvvm.repository.RepositoryImpl
import com.qxy.douyinDemo.mvvm.viewModel.MovieRankViewModel
import com.qxy.douyinDemo.ui.listAdapter.MovieItemAdapter

class MovieFragment(private val movieTypeCreate: Int) :
    BaseFragment<RepositoryImpl, MovieRankViewModel, FragmentMovieBinding>() {
    private val movieItemList = ArrayList<MovieItem>()

    override fun getContentViewId(): Int = R.layout.fragment_movie

    override fun processLogic(savedInstanceState: Bundle?) {
        Log.d("MovieFragment", "processLogic called!")
    }

    override fun setListener() {
        val layoutManager = LinearLayoutManager(context)
        val adapter = MovieItemAdapter(movieItemList, movieTypeCreate, requireContext())
        initData(adapter)
        binding.moviesList.apply {
            this.layoutManager = layoutManager
            this.addItemDecoration(
                MovieItemDecoration(
                    requireActivity(),
                    LinearLayoutManager.VERTICAL,
                    R.layout.item_top_decor_movie,
                    mViewModel!!
                )
            )
            this.adapter = adapter
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
        }
    }

    fun initData(adapter : MovieItemAdapter) {
        when (movieTypeCreate) {
            MovieItem.type.CINEMA_MOVIE_TYPE -> {
                mViewModel?.getMovieRankFromBackEnd()
                mViewModel?.realMovieRank?.observe(this) {
                    for (i in 0 until it.size) {
                        movieItemList.add(it[i])
                        Log.d("realMovieRank_data", "initData: ${it[i].movieTitle}")
                    }
                    adapter.notifyDataSetChanged()
                }
            }

            MovieItem.type.WEB_MOVIE_TYPE -> {
                for (i in 0..20) {
                    movieItemList.add(
                        MovieItem(
                            null, "title: $i", "subtitle1: $i",
                            "subtitle2: $i", "subtitle3: $i",
                            MovieItem.type.WEB_MOVIE_TYPE
                        )
                    )
                }
            }
        }
    }

}
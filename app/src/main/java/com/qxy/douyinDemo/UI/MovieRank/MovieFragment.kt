package com.qxy.douyinDemo.UI.movieRank

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.qxy.douyinDemo.R
import com.qxy.douyinDemo.UI.MovieRank.MovieItemDecoration
import com.qxy.douyinDemo.bean.MovieItem
import com.qxy.douyinDemo.ui.movieRank.MovieItemAdapter

class MovieFragment(val movieTypeCreate: Int): Fragment() {
    private val movieItemList = ArrayList<MovieItem>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val returnView = inflater.inflate(R.layout.fragment_movie, container, false)
        val layoutManager = LinearLayoutManager(context)
        val adapter = MovieItemAdapter(movieItemList, movieTypeCreate)
        val recyclerView = returnView.findViewById<RecyclerView>(R.id.movies_list)

        initData()
        recyclerView.apply {
            this.layoutManager = layoutManager
            this.addItemDecoration(MovieItemDecoration())
            this.adapter = adapter
        }
        return returnView
    }

    fun initData() {
        //TODO: not implement yet
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

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        Log.d("WebMovieFragment", "onAttach called!")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Log.d("WebMovieFragment", "onCreate called!")
    }

    override fun onResume() {
        super.onResume()
//        Log.d("WebMovieFragment", "onResume called!")
    }
}
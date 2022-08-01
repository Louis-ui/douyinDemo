package com.qxy.douyinDemo.UI.MovieRank

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.qxy.douyinDemo.R
import com.qxy.douyinDemo.bean.MovieItem

class CinemaMovieFragment : Fragment() {
    private val cinemaMovieItemList = ArrayList<MovieItem>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        Log.d("CinemaMovieFragment", "onCreateView called!")
        val returnView = inflater.inflate(R.layout.fragment_cinema_movie, container, false)
        val layoutManager = LinearLayoutManager(context)
        val adapter = MovieItemAdapter(cinemaMovieItemList)
        val recyclerView = returnView.findViewById<RecyclerView>(R.id.cinema_list)

        initData()
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(MovieItemDecoration())
        recyclerView.adapter = adapter

        return returnView
    }

    private fun initData() {
        for (i in 0..20) {
            cinemaMovieItemList.add(MovieItem("title$i", "subtitle1: $i",
            "subtitle2: $i", "subtitle3: $i"))
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("CinemaMovieFragment", "onAttach called!")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("CinemaMovieFragment", "onCreate called!")
    }

    override fun onResume() {
        super.onResume()
        Log.d("CinemaMovieFragment", "onResume called!")
    }


}
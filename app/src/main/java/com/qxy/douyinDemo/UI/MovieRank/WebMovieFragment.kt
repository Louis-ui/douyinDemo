package com.qxy.douyinDemo.UI.MovieRank

import android.content.Context
import android.graphics.Movie
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

class WebMovieFragment : Fragment() {
    private val webMovieItemList = ArrayList<MovieItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        Log.d("WebMovieFragment", "onCreateView called!")
        val returnView = inflater.inflate(R.layout.fragment_web_movie, container, false)
        val layoutManager = LinearLayoutManager(context)
        val adapter = WebMovieItemAdapter(webMovieItemList)
        val recyclerView = returnView.findViewById<RecyclerView>(R.id.web_list)

        initData()
        recyclerView.apply {
            this.layoutManager = layoutManager
            this.addItemDecoration(MovieItemDecoration())
            this.adapter = adapter
        }
        return returnView
    }

    private fun initData() {
        for (i in 0..20) {
            webMovieItemList.add(
                MovieItem(
                    "title$i", "subtitle1: $i",
                    "subtitle2: $i", "subtitle3: $i"
                )
            )
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        Log.d("WebMovieFragment", "onAttach called!")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("WebMovieFragment", "onCreate called!")
    }

    override fun onResume() {
        super.onResume()
        Log.d("WebMovieFragment", "onResume called!")
    }
}
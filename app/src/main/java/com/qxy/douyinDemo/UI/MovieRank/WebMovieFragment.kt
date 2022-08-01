package com.qxy.douyinDemo.UI.MovieRank

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qxy.douyinDemo.R

class WebMovieFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("WebMovieFragment", "onCreateView called!")
        return inflater.inflate(R.layout.fragment_web_movie, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("WebMovieFragment", "onAttach called!")
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
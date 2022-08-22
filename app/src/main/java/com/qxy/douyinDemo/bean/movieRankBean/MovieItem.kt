package com.qxy.douyinDemo.bean.movieRankBean

import android.net.Uri

class MovieItem(
    var moviePost: Uri?,
    val movieTitle: String,
    val movieSubtitle1: String,
    val movieSubtitle2: String,
    val movieSubtitle3: String,
    val movieType: Int) {
    object type {
        const val CINEMA_MOVIE_TYPE = 0
        const val WEB_MOVIE_TYPE = 1
    }
}
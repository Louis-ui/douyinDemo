package com.qxy.douyinDemo.bean.MovieRankBean

import android.graphics.Bitmap
import android.net.Uri

class MovieItem(
    var moviePost: Uri?,
    val movieTitle: String,
    val movieSubtitle1: String,
    val movieSubtitle2: String,
    val movieSubtitle3: String,
    val movieType: Int
) {
    object type {
        val CINEMA_MOVIE_TYPE = 0
        val WEB_MOVIE_TYPE = 1
    }

}
package com.qxy.douyinDemo.UI.MovieRank

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.qxy.douyinDemo.R
import com.qxy.douyinDemo.bean.MovieItem

class WebMovieItemAdapter(val movieItemList: List<MovieItem>): RecyclerView.Adapter<WebMovieItemAdapter.ViewHolder>() {
    inner class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val moviePost: ImageView = itemview.findViewById(R.id.web_movie_post)
        val movieTitleLayout: LinearLayout = itemview.findViewById(R.id.web_movie_title_layout)
        val movieRight: LinearLayout = itemView.findViewById(R.id.web_movie_right)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_web_movie,
            parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieItem = movieItemList[position]
        holder.movieTitleLayout.apply {
            findViewById<TextView>(R.id.web_movie_title).text = movieItem.movieTitle
            findViewById<TextView>(R.id.web_movie_subtitle1).text = movieItem.movieSubtitle1
            findViewById<TextView>(R.id.web_movie_subtitle2).text = movieItem.movieSubtitle2
            findViewById<TextView>(R.id.web_movie_subtitle3).text = movieItem.movieSubtitle3
        }
    }

    override fun getItemCount(): Int = movieItemList.size
}
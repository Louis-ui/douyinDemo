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

class MovieItemAdapter(val movieItemList: List<MovieItem> ): RecyclerView.Adapter<MovieItemAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val moviePost: ImageView = itemView.findViewById(R.id.movie_post)
        val movieTitleLayout: LinearLayout = itemView.findViewById(R.id.movie_title_layout)
        val movieRight: LinearLayout = itemView.findViewById(R.id.movie_right)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_list_item_cinema, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieItem = movieItemList[position]
        holder.movieTitleLayout.findViewById<TextView>(R.id.movie_title).text = movieItem.movieTitle
        holder.movieTitleLayout.findViewById<TextView>(R.id.movie_subtitle1).text = movieItem.movieSubtitle1
        holder.movieTitleLayout.findViewById<TextView>(R.id.movie_subtitle2).text = movieItem.movieSubtitle2
        holder.movieTitleLayout.findViewById<TextView>(R.id.movie_subtitle3).text = movieItem.movieSubtitle3
    }

    override fun getItemCount(): Int = movieItemList.size
}
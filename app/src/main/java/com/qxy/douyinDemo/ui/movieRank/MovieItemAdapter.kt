package com.qxy.douyinDemo.ui.movieRank

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.qxy.douyinDemo.R
import com.qxy.douyinDemo.base.BaseRvAdapter
import com.qxy.douyinDemo.bean.MovieRankBean.MovieItem
import com.qxy.douyinDemo.bean.RankInfos
import com.qxy.douyinDemo.databinding.ListItemMovieBinding

class MovieItemAdapter(
    private val movieItemList: List<MovieItem>,
    private val movieType: Int,
    private val mContext: Context) : RecyclerView.Adapter<MovieItemAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //val mContext: Context = itemView.context
        val moviePost: ImageView = itemView.findViewById(R.id.movie_post)
        val movieRight: LinearLayout = itemView.findViewById(R.id.movie_right)
        val movieName: TextView = itemView.findViewById(R.id.movie_title)
        val movieSubtitle1: TextView = itemView.findViewById(R.id.movie_subtitle1)
        val movieSubtitle2: TextView = itemView.findViewById(R.id.movie_subtitle2)
        val movieSubtitle3: TextView = itemView.findViewById(R.id.movie_subtitle3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieItem = movieItemList[position]
        holder.movieName.text = movieItem.movieTitle
        holder.movieSubtitle1.text = movieItem.movieSubtitle1
        holder.movieSubtitle2.text = "热度：" + movieItem.movieSubtitle2
        holder.movieSubtitle3.text = "上映日期" + movieItem.movieSubtitle3
        Glide.with(mContext).load(movieItem.moviePost).into(holder.moviePost)
        // set button onClick
        holder.movieRight.findViewById<Button>(R.id.buy_ticket).setOnClickListener {
            Toast.makeText(it.context, "called!", Toast.LENGTH_SHORT).show()
        }
        Glide.with(holder.moviePost.context).load(movieItem.moviePost).into(holder.moviePost)
        Log.d("onBindViewHolder", "${movieItem.moviePost}")

        when (movieType) {
            MovieItem.type.CINEMA_MOVIE_TYPE -> {
                // do nothing
            }

            MovieItem.type.WEB_MOVIE_TYPE -> {
                holder.movieRight.isVisible = false
            }
        }
    }

    override fun getItemCount(): Int = movieItemList.size
}

//class MovieItemAdapter(private val movieType: Int, private val movieItemList: ArrayList<MovieItem>) : BaseRvAdapter<MovieItem, MovieItemViewHolder>() {
//    override fun handleData(holder: MovieItemViewHolder, d: MovieItem, position: Int) {
//        dataList = movieItemList
//        val movieItem = dataList?.get(position)
//        val root = holder.viewDataBinding
//        root.movieTitle.text = d.movieTitle
//        root.movieSubtitle1.text = d.movieSubtitle1
//        root.movieSubtitle2.text = d.movieSubtitle2
//        root.movieSubtitle3.text = d.movieSubtitle3
//        Glide.with(mContext).load(movieItem?.moviePost).into(root.moviePost)
//        // set button onClick
//        root.buyTicket.setOnClickListener {
//            Toast.makeText(it.context, "called!", Toast.LENGTH_SHORT).show()
//        }
//
//        when (movieType) {
//            MovieItem.type.CINEMA_MOVIE_TYPE -> {
//                // do nothing
//            }
//
//            MovieItem.type.WEB_MOVIE_TYPE -> {
//                root.movieRight.isVisible = false
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
//        var binding: ListItemMovieBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
//            R.layout.list_item_movie, parent, false)
//        return MovieItemViewHolder(binding)
//    }
//}

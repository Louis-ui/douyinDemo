package com.qxy.douyinDemo.ui.followFans

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.qxy.douyinDemo.R
import com.qxy.douyinDemo.base.BaseRvAdapter
import com.qxy.douyinDemo.bean.FollowItem

class FollowItemAdapter(private val followItemList: List<FollowItem>) :
    RecyclerView.Adapter<FollowItemAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userPost: ImageView = itemView.findViewById(R.id.user_post)
        val username: TextView = itemView.findViewById(R.id.username)
        val gender: TextView = itemView.findViewById(R.id.gender)
        val country: TextView = itemView.findViewById(R.id.country)
        val province: TextView = itemView.findViewById(R.id.province)
        val city: TextView = itemView.findViewById(R.id.city)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FollowItemAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_follow, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FollowItemAdapter.ViewHolder, position: Int) {
        val followItem = followItemList[position]
        holder.username.text = followItem.username
        holder.gender.text = followItem.gender
        holder.country.text = followItem.country
        holder.province.text = followItem.province
        holder.city.text = followItem.city
    }

    override fun getItemCount(): Int = followItemList.size

}
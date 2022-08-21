package com.qxy.douyinDemo.UI.ListAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.qxy.douyinDemo.R
import com.qxy.douyinDemo.base.BaseRvAdapter
import com.qxy.douyinDemo.bean.List
import com.qxy.douyinDemo.databinding.MyListItem1Binding

class MyFragmentItem1Adapter : BaseRvAdapter<List,MyFragmentItemViewHolder>() {
  /*  override fun handleData(holder: MyFragmentItemViewHolder, d: String, position: Int) {
    holder.viewDataBinding.itemText1.text=d

    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyFragmentItemViewHolder {
        var binding :MyListItem1Binding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),
           R.layout.my_list_item1,parent,false)
        return MyFragmentItemViewHolder(binding)
    }

    override fun handleData(holder: MyFragmentItemViewHolder, d: List, position: Int) {
        println(d.cover)
        Glide.with(mContext).load(d.cover).into(holder.viewDataBinding.item1Img1)
    }

}
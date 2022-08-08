package com.qxy.douyinDemo.UI.ListAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import com.qxy.douyinDemo.R
import com.qxy.douyinDemo.base.BaseRvAdapter
import com.qxy.douyinDemo.databinding.MyListItem1Binding

class MyFragmentItem1Adapter : BaseRvAdapter<String,MyFragmentItemViewHolder>() {
    override fun handleData(holder: MyFragmentItemViewHolder, d: String, position: Int) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyFragmentItemViewHolder {
        var binding :MyListItem1Binding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),
           R.layout.my_list_item1,parent,false)
        return MyFragmentItemViewHolder(binding)
    }

}
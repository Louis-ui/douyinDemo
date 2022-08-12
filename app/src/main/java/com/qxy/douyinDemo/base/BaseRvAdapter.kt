package com.qxy.douyinDemo.base

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


abstract class BaseRvAdapter<D, V : BaseRvAdapter.ViewHolder<*>> : RecyclerView.Adapter<V>() {
    protected var onItemClickListener: OnItemClickListener<D>? = null
    protected var dataList: ArrayList<D>? = null
    protected var mContext: Context? = null

    open fun refresh(list: List<D>) {
        dataList = list as ArrayList<D> /* = java.util.ArrayList<D> */
        notifyDataSetChanged()
    }

    open fun loadMore(list: List<D>) {
        if (dataList == null) dataList = ArrayList<D>()
        val start = dataList!!.size
        dataList!!.addAll(list as Collection<D>)
        notifyItemRangeChanged(start, list.size)
    }

    override fun onBindViewHolder(holder: V, position: Int) {
        mContext = holder.itemView.context
        holder.itemView.setOnClickListener(View.OnClickListener {
            if (onItemClickListener == null) return@OnClickListener
            onItemClickListener!!.onItemClick(dataList!![position], position)
        })

        handleData(holder as V, dataList!![position], position)
    }

    protected abstract fun handleData(holder: V, d: D, position: Int)
    override fun getItemCount(): Int {
        return if (dataList == null) 0 else dataList!!.size
    }

      open class ViewHolder<B : ViewDataBinding>(var viewDataBinding: B) : RecyclerView.ViewHolder(
        viewDataBinding!!.root
    )

    interface OnItemClickListener<D> {
        fun onItemClick(data: D, pos: Int)
    }

    open fun setOnItemClickListener1(onItemClickListener: BaseRvAdapter.OnItemClickListener<D>?) {
        this.onItemClickListener = onItemClickListener
    }

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): V

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

}



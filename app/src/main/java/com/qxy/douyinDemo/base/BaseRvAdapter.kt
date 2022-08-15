package com.qxy.douyinDemo.base

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * A base RecyclerView Adapter, inherited from RecyclerView.Adapter<VH>. It
 * contains activity context, so it can easily using glide and more.
 * @param D Data class
 * @param V Customized ViewHolder class
 * @property onItemClickListener ItemClickListener object
 * @property dataList Data list
 * @property mContext Activity context
 * @author SunMoon
 */
abstract class BaseRvAdapter<D, V : BaseRvAdapter.ViewHolder<*>> : RecyclerView.Adapter<V>() {
    protected var onItemClickListener: OnItemClickListener<D>? = null
    protected var dataList: ArrayList<D>? = null
    protected var mContext: Context? = null

    /**
     * update list and notify data changed
     * @param list New data list
     */
    open fun refresh(list: List<D>) {
        dataList = list as ArrayList<D> /* = java.util.ArrayList<D> */
        notifyDataSetChanged()
    }

    /**
     * insert new data into data list
     * @param list New data need to insert
     */
    open fun loadMore(list: List<D>) {
        if (dataList == null) dataList = ArrayList<D>()
        val start = dataList!!.size
        dataList!!.addAll(list as Collection<D>)
        notifyItemRangeChanged(start, list.size)
    }

    /**
     * wrapping of binding data and click event callbacks to view items
     * @param holder view item
     * @param position item in data list
     */
    override fun onBindViewHolder(holder: V, position: Int) {
        mContext = holder.itemView.context
        holder.itemView.setOnClickListener(View.OnClickListener {
            if (onItemClickListener == null) return@OnClickListener
            onItemClickListener!!.onItemClick(dataList!![position], position)
        })

        handleData(holder, dataList!![position], position)
    }

    /**
     * binding data to the view item(like set text or picture)
     * @param holder view holder of view item
     * @param d view item's data in data list
     * @param position view item's position in data list
     */
    protected abstract fun handleData(holder: V, d: D, position: Int)

    /**
     * get data list count
     * @return item count in data list
     */
    override fun getItemCount(): Int = if (dataList == null) 0 else dataList!!.size

    /**
     * inner class of Adapter - ViewHolder. Use to handle data binding.
     * @param viewDataBinding view data binding class
     */
    open class ViewHolder<B : ViewDataBinding>(var viewDataBinding: B) :
        RecyclerView.ViewHolder(viewDataBinding.root)

    /**
     * item click listener interface
     * @property onItemClick call back function
     */
    interface OnItemClickListener<D> {
        fun onItemClick(data: D, pos: Int)
    }

    /**
     * binding clickListener to the item
     * @param onItemClickListener clickListener object
     */
    open fun setOnItemClickListener1(onItemClickListener: BaseRvAdapter.OnItemClickListener<D>?) {
        this.onItemClickListener = onItemClickListener
    }

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): V

    /**
     * {@inheritDoc}
     */
    override fun getItemId(position: Int): Long = position.toLong()
}
package com.qxy.douyinDemo.UI.Fragment

import android.database.AbstractCursor
import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintSet
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.appbar.AppBarLayout
import com.qxy.douyinDemo.R
import com.qxy.douyinDemo.UI.ListAdapter.MyFragmentItem1Adapter
import com.qxy.douyinDemo.base.BaseFragment
import com.qxy.douyinDemo.base.BaseRvAdapter
import com.qxy.douyinDemo.bean.User
import com.qxy.douyinDemo.bean.VideoBean.List
import com.qxy.douyinDemo.bean.VideoBean.Vbean
import com.qxy.douyinDemo.databinding.FragmentMyBinding
import com.qxy.douyinDemo.mvvm.repository.RepositoryImpl
import com.qxy.douyinDemo.mvvm.viewModel.MyFragmentViewModel
import kotlin.random.Random

class MyFragment : BaseFragment<RepositoryImpl,MyFragmentViewModel,FragmentMyBinding>() {
    override fun getContentViewId(): Int {
        return R.layout.fragment_my
    }

    override fun processLogic(savedInstanceState: Bundle?) {
        //通过随机数来设置点赞数
        setLike()
    }

    override fun setListener() {
        setBarLayoutListener()
        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {

    }
    //通过随机数来设置点赞数
    fun setLike(){
        binding.myText3.text=Random.nextInt(6,60).toString();
        binding.myText4.text=Random.nextInt(6,60).toString();
        binding.myText5.text=Random.nextInt(6,60).toString();
    }
    //进行个人资料的设置
    fun setUserMessage(access_token:String,open_id:String)
    {
        mViewModel?.ToMessage(access_token,open_id)?.observe(this, Observer { t : User->
            Glide.with(context).load(t.avatar).into(binding.MyImag)
            binding.myText1.text=t.nickname
            binding.toolbarText.text=t.nickname
        })
    }
    //进行个人视频的数据获取
    fun setVideoMessage(open_id: String,cursor:String,count:String)
    {
        binding.myRecyclerView.layoutManager=StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
        mViewModel?.ToVideo(open_id,cursor,count)?.observe(this, Observer { t:Vbean->
         var adapter:MyFragmentItem1Adapter= MyFragmentItem1Adapter()
            t.data?.list?.let { adapter.loadMore(it) }
            adapter.setOnItemClickListener1(object :BaseRvAdapter.OnItemClickListener<List>{
                override fun onItemClick(data: List, pos: Int) {
                //在这里设置作品点击后的跳转界面
                }

            })
        })
    }
    //进行AppBarLayout的滑动监听
    fun setBarLayoutListener()
    {
        binding.myAppBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener({
                appbar:AppBarLayout,i:Int->
            if(Math.abs(i)<appbar.totalScrollRange)
            {
                binding.toolbar.visibility=View.GONE
            }
            else{
                binding.toolbar.visibility=View.VISIBLE
            }
        }
        ))
    }

}
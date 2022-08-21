package com.qxy.douyinDemo.UI.Fragment

import android.content.Intent
import android.database.AbstractCursor
import android.os.Bundle
import android.util.Log
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
import com.qxy.douyinDemo.app.AppSetting
import com.qxy.douyinDemo.base.BaseFragment
import com.qxy.douyinDemo.base.BaseRvAdapter
import com.qxy.douyinDemo.bean.User
import com.qxy.douyinDemo.bean.VideoBean.List
import com.qxy.douyinDemo.bean.VideoBean.Vbean
import com.qxy.douyinDemo.databinding.FragmentMyBinding
import com.qxy.douyinDemo.mvvm.repository.RepositoryImpl
import com.qxy.douyinDemo.mvvm.viewModel.MyFragmentViewModel
import com.qxy.douyinDemo.UI.movieRank.MovieRankActivity
import com.qxy.douyinDemo.bean.VideoBean.Data
import com.qxy.douyinDemo.network.OkHttpHelper
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.random.Random

class MyFragment : BaseFragment<RepositoryImpl,MyFragmentViewModel,FragmentMyBinding>() {
    override fun getContentViewId(): Int {
        return R.layout.fragment_my
    }

    override fun processLogic(savedInstanceState: Bundle?) {
        //通过随机数来设置点赞数
        setLike()
       // AppSetting.ACCESS_TOKEN?.let { AppSetting.OPEN_ID?.let { it1 -> setUserMessage(it, it1) } }
    }

    override fun setListener() {
        setBarLayoutListener()
        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when (p0) {
            binding.button1 -> {
               println(AppSetting.ACCESS_TOKEN2+AppSetting.OPEN_ID+"111")
                AppSetting.ACCESS_TOKEN2?.let { AppSetting.OPEN_ID?.let { it1 ->
                    setUserMessage(it,
                        it1
                    )
                } }
                AppSetting.ACCESS_TOKEN3?.let { AppSetting.OPEN_ID?.let { it1 ->
                    setVideoMessage(it,
                        it1,"0","10")
                } }


            }
            binding.button2 -> {
                startActivity(Intent(context , MovieRankActivity::class.java))
            }
        }
    }
    //通过随机数来设置点赞数
    fun setLike(){
        binding.myText3.text=Random.nextInt(6,60).toString();
        binding.myText4.text=Random.nextInt(6,60).toString();
        binding.myText5.text=Random.nextInt(6,60).toString();
    }
    //进行个人资料的设置
    fun setUserMessage(access_token : String,open_id : String)
    {
        mViewModel?.ToMessage(access_token,open_id)?.observe(this, Observer { t : User->
            Log.d("XXXX","XXXXXXX")
            Glide.with(context).load(t.avatar).into(binding.MyImag)
            binding.myText1.text=t.nickname
            binding.toolbarText.text=t.nickname
        })
    }
    //进行个人视频的数据获取
    fun setVideoMessage(access_token: String,open_id: String,cursor:String,count:String)
    {
        binding.myRecyclerView.layoutManager=StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
        mViewModel?.ToVideo(access_token,open_id,cursor,count)?.observe(this, Observer { t:Data->
            Log.d("XXXX","6666666+${AppSetting.ACCESS_TOKEN}")
         var adapter:MyFragmentItem1Adapter= MyFragmentItem1Adapter()
            if(t.list!=null)
            {
                Log.d("XXXX","6666666+${t.list.size}")
                adapter.loadMore(t.list)
                adapter.setOnItemClickListener1(object :BaseRvAdapter.OnItemClickListener<List>{
                    override fun onItemClick(data: List, pos: Int) {
                        //在这里设置作品点击后的跳转界面
                    }

                })
                binding.myRecyclerView.adapter=adapter
            }

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
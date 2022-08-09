package com.qxy.douyinDemo.ui.followFans

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.qxy.douyinDemo.R
import com.qxy.douyinDemo.base.BaseFragment
import com.qxy.douyinDemo.bean.FollowItem
import com.qxy.douyinDemo.databinding.FragmentFollowBinding
import com.qxy.douyinDemo.mvvm.repository.RepositoryImpl
import com.qxy.douyinDemo.mvvm.viewModel.FollowViewModel

class FollowFragment : BaseFragment<RepositoryImpl, FollowViewModel, FragmentFollowBinding>() {

    private val followItemList = ArrayList<FollowItem>()

    override fun getContentViewId(): Int {
        return R.layout.fragment_follow
    }

    override fun processLogic(savedInstanceState: Bundle?) {
        Log.d("FollowFragment", "processLogic called!")
    }

    override fun setListener() {
        val layoutManager = LinearLayoutManager(context)
        val adapter = FollowItemAdapter(followItemList)
        initData()
        binding.followList.apply {
            this.layoutManager = layoutManager
            this.adapter = adapter
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {

        }
    }

    private fun initData() {
        for (i in 0..20) {
            followItemList.add(
                FollowItem(
                    "username: $i", "country: $i",
                    "province: $i", "city: $i",
                    "gender"
                )
            )
        }
    }

}
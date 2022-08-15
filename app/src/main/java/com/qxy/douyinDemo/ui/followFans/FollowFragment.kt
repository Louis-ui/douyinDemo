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

class FollowFragment(private val followTypeCreate: Int) :
    BaseFragment<RepositoryImpl, FollowViewModel, FragmentFollowBinding>() {

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
            when (followTypeCreate) {
                FollowItem.type.FOLLOW_TYPE -> {
                    this.addItemDecoration(
                        FollowItemDecoration(
                            requireActivity(),
                            LinearLayoutManager.VERTICAL,
                            R.layout.item_top_decor_follow
                        )
                    )
                }

                FollowItem.type.FANS_TYPE -> {
                    this.addItemDecoration(
                        FollowItemDecoration(
                            requireActivity(),
                            LinearLayoutManager.VERTICAL,
                            R.layout.item_top_decor_fans
                        )
                    )
                }
            }
            this.adapter = adapter
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {

        }
    }

    private fun initData() {
        when (followTypeCreate) {
            FollowItem.type.FOLLOW_TYPE -> {
                for (i in 0..20) {
                    followItemList.add(
                        FollowItem(
                            "username: $i", "country: $i",
                            "province: $i", "city: $i",
                            "关注",
                            FollowItem.type.FOLLOW_TYPE
                        )
                    )
                }
            }

            FollowItem.type.FANS_TYPE -> {
                for (i in 0..20) {
                    followItemList.add(
                        FollowItem(
                            "username: $i", "country: $i",
                            "province: $i", "city: $i",
                            "粉丝",
                            FollowItem.type.FANS_TYPE
                        )
                    )
                }
            }
        }
    }

}
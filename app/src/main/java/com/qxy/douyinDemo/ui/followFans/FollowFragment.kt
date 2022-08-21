package com.qxy.douyinDemo.ui.followFans

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.qxy.douyinDemo.R
import com.qxy.douyinDemo.app.AppSetting
import com.qxy.douyinDemo.base.BaseFragment
import com.qxy.douyinDemo.bean.followBean.FollowItem
import com.qxy.douyinDemo.databinding.FragmentFollowBinding
import com.qxy.douyinDemo.mvvm.repository.RepositoryImpl
import com.qxy.douyinDemo.mvvm.viewModel.FollowViewModel
import com.qxy.douyinDemo.ui.listAdapter.MovieItemDecoration

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
        val adapter = FollowItemAdapter(followItemList, requireContext())
        initData(adapter)
        binding.followList.apply {
            this.layoutManager = layoutManager
            when (followTypeCreate) {
                FollowItem.type.FOLLOW_TYPE -> {
                    this.addItemDecoration(
                        MovieItemDecoration(
                            requireActivity(),
                            LinearLayoutManager.VERTICAL,
                            R.layout.item_top_decor_follow
                        )
                    )
                }

                FollowItem.type.FANS_TYPE -> {
                    this.addItemDecoration(
                        MovieItemDecoration(
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

    private fun initData(adapter: FollowItemAdapter) {
        when (followTypeCreate) {
            FollowItem.type.FOLLOW_TYPE -> {
                mViewModel?.getFollowList(20, AppSetting.OPEN_ID, 0)
                mViewModel?.realFollowList?.observe(this) {
                    for (i in 0 until it.size) {
                        followItemList.add(it[i])
                        Log.d("realMovieRank_data", "initData: ${it[i].username}")
                    }
                    adapter.notifyDataSetChanged()
                }
            }

            FollowItem.type.FANS_TYPE -> {
                mViewModel?.getFansList(20, AppSetting.OPEN_ID, 0)
                mViewModel?.realFansList?.observe(this) {
                    for (i in 0 until it.size) {
                        followItemList.add(it[i])
                        Log.d("realMovieRank_data", "initData: ${it[i].username}")
                    }
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }

}
package com.qxy.douyinDemo.ui.followFans

import android.os.Bundle
import android.util.Log
import android.view.View
import com.qxy.douyinDemo.R
import com.qxy.douyinDemo.base.BaseFragment
import com.qxy.douyinDemo.databinding.FragmentFollowBinding
import com.qxy.douyinDemo.mvvm.repository.RepositoryImpl
import com.qxy.douyinDemo.mvvm.viewModel.FollowViewModel

class FollowFragment : BaseFragment<RepositoryImpl, FollowViewModel, FragmentFollowBinding>() {
    override fun getContentViewId(): Int {
        return R.layout.fragment_follow
    }

    override fun processLogic(savedInstanceState: Bundle?) {
        Log.d("FollowFragment", "processLogic called!")
    }

    override fun setListener() {

    }

    override fun onClick(v: View?) {
        when (v?.id) {

        }
    }

}
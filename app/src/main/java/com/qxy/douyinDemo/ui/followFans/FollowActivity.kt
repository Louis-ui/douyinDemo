package com.qxy.douyinDemo.ui.followFans

import android.util.Log
import android.view.View
import android.widget.TableLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.qxy.douyinDemo.R
import com.qxy.douyinDemo.base.BaseActivity
import com.qxy.douyinDemo.bean.FollowItem
import com.qxy.douyinDemo.mvvm.repository.RepositoryImpl
import com.qxy.douyinDemo.mvvm.viewModel.FollowViewModel
import com.qxy.douyinDemo.databinding.ActivityFollowBinding

class FollowActivity : BaseActivity<RepositoryImpl, FollowViewModel, ActivityFollowBinding>() {

    val followViews = ArrayList<Fragment>()

    override fun getContextViewId(): Int {
        return R.layout.activity_follow
    }

    override fun processLogic() {
        Log.d("FollowActivity", "processLogic called!")
    }

    override fun setListener() {
        followViews.add(FollowFragment(FollowItem.type.FOLLOW_TYPE))
        followViews.add(FollowFragment(FollowItem.type.FANS_TYPE))
        binding.viewPager.adapter = FollowListPagerAdapter(supportFragmentManager, followViews)
        binding.viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))
        binding.tabLayout.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(binding.viewPager))
    }

    override fun onClick(v: View?) {
        when (v?.id) {

        }
    }

    class FollowListPagerAdapter(
        fragmentManager: FragmentManager,
        private val followViews: ArrayList<Fragment>
    ) : FragmentPagerAdapter(fragmentManager) {

        override fun getCount(): Int = followViews.size
        override fun getItem(position: Int): Fragment = followViews[position]

    }

}
package com.qxy.douyinDemo.UI.ViewpagerAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyFragmentViewpagerAdapter(fa: FragmentActivity, private val tabs: Array<Fragment>) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return tabs.size
    }

    override fun createFragment(position: Int): Fragment {
        return tabs.get(position)
    }
}
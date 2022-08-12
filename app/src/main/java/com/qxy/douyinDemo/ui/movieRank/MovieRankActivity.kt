package com.qxy.douyinDemo.ui.movieRank

import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.qxy.douyinDemo.R
import com.qxy.douyinDemo.base.BaseActivity
import com.qxy.douyinDemo.bean.MovieRankBean.MovieItem
import com.qxy.douyinDemo.databinding.ActivityMovieRankBinding
import com.qxy.douyinDemo.mvvm.repository.RepositoryImpl
import com.qxy.douyinDemo.mvvm.viewModel.MovieRankViewModel

class MovieRankActivity: BaseActivity<RepositoryImpl, MovieRankViewModel, ActivityMovieRankBinding>() {
    val views = ArrayList<Fragment>()

    override fun getContextViewId(): Int {
        return R.layout.activity_movie_rank
    }

    override fun processLogic() {
        Log.d("MovieRankActivity", "processLogic called!")
    }

    override fun setListener() {
        views.add(MovieFragment(MovieItem.type.CINEMA_MOVIE_TYPE))
        views.add(MovieFragment(MovieItem.type.WEB_MOVIE_TYPE))
        binding.ranklistViewpager.adapter = RankListPagerAdapter(supportFragmentManager, views)
        binding.ranklistViewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))
        binding.tabLayout.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(binding.ranklistViewpager))
    }

    override fun onClick(v: View?) {
        when (v?.id) {

        }
    }

    class RankListPagerAdapter(
        fragmentManager: FragmentManager,
        private val views: ArrayList<Fragment>) : FragmentPagerAdapter(fragmentManager) {

        override fun getCount(): Int = views.size
        override fun getItem(position: Int): Fragment = views[position]
    }
}
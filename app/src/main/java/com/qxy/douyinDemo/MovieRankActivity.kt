package com.qxy.douyinDemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MovieRankActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_rank)

        Log.d("MovieRankActivity", "onCreate called!")

        val viewPager: ViewPager = findViewById(R.id.ranklist_viewpager)
        val tabLayout: TabLayout = findViewById(R.id.tab_layout)

        val views = ArrayList<Fragment>()
        views.add(CinemaMovieFragment())
        views.add(WebMovieFragment())

        val rankListPagerAdapter = RankListPagerAdapter(supportFragmentManager, views)
        viewPager.adapter = rankListPagerAdapter

//        tabLayout.setupWithViewPager(viewPager)
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(viewPager))
    }

    override fun onStart() {
        super.onStart()
        Log.d("MovieRankActivity", "onStart called!")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MovieRankActivity", "onResume called!")
    }

    class RankListPagerAdapter(
        fragmentManager: FragmentManager,
        private val views: ArrayList<Fragment>) : FragmentPagerAdapter(fragmentManager) {

        override fun getCount(): Int = views.size
        override fun getItem(position: Int): Fragment = views[position]
    }
}
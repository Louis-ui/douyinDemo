package com.qxy.douyinDemo.UI.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.qxy.douyinDemo.R
import com.qxy.douyinDemo.base.BaseFragment
import com.qxy.douyinDemo.databinding.FragmentMyBinding
import com.qxy.douyinDemo.mvvm.repository.RepositoryImpl
import com.qxy.douyinDemo.mvvm.viewModel.MyFragmentViewModel

class MyFragment : BaseFragment<RepositoryImpl,MyFragmentViewModel,FragmentMyBinding>() {
    override fun getContentViewId(): Int {
        return R.layout.fragment_my
    }

    override fun processLogic(savedInstanceState: Bundle?) {

   TabLayoutMediator(binding.myTab,binding.myViewpager2,TabLayoutMediator.TabConfigurationStrategy(){ tab: TabLayout.Tab, i: Int ->

   })
    }

    override fun setListener() {

    }

    override fun onClick(p0: View?) {

    }

}
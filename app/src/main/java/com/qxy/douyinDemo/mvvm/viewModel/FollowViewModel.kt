package com.qxy.douyinDemo.mvvm.viewModel

import android.app.Application
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.qxy.douyinDemo.app.AppSetting
import com.qxy.douyinDemo.base.BaseViewModel
import com.qxy.douyinDemo.bean.followBean.FansInfos
import com.qxy.douyinDemo.bean.followBean.FollowInfos
import com.qxy.douyinDemo.bean.followBean.FollowItem
import com.qxy.douyinDemo.mvvm.repository.RepositoryImpl
import com.qxy.douyinDemo.network.ApiResult
import kotlinx.coroutines.launch

class FollowViewModel(application: Application) : BaseViewModel<RepositoryImpl>(application) {
    var followList = MutableLiveData<FollowInfos>()
    var fansList = MutableLiveData<FansInfos>()

    var realFollowList: LiveData<ArrayList<FollowItem>> = Transformations.map(followList) { follow ->
        val tempList = ArrayList<FollowItem>()
        for(i in 1 until follow.list.size) {
            val tempFollowItem = follow.list[i]
            tempList.add(
                FollowItem(
                    Uri.parse(tempFollowItem.avatar),
                    tempFollowItem.nickname,
                    tempFollowItem.country,
                    tempFollowItem.province,
                    tempFollowItem.city,
                    tempFollowItem.gender,
                    FollowItem.type.FOLLOW_TYPE
            )
            )
        }
        tempList
    }

    var realFansList: LiveData<ArrayList<FollowItem>> = Transformations.map(fansList) { fans ->
        val tempList = ArrayList<FollowItem>()
        for(i in 1 until fans.list.size) {
            val tempFollowItem = fans.list[i]
            tempList.add(
                FollowItem(
                    Uri.parse(tempFollowItem.avatar),
                    tempFollowItem.nickname,
                    tempFollowItem.country,
                    tempFollowItem.province,
                    tempFollowItem.city,
                    tempFollowItem.gender,
                    FollowItem.type.FANS_TYPE
                )
            )
        }
        tempList
    }

    fun getFollowList(count: Int, open_id: String?, cursor: Int): LiveData<FollowInfos> {
        viewModelScope.launch {
            when (val result =
                AppSetting.CLIENT_TOKEN?.let {
                    repository?.getFollowInfo(
                        it,
                        count,
                        open_id,
                        cursor
                    )
                }) {
                is ApiResult.Success -> {
                    followList.value = result.data!!
                }
                is ApiResult.Error.ServerError -> {

                }
                is ApiResult.Error.Exception -> {

                }
                else -> {}
            }
        }
        return followList
    }

    fun getFansList(count: Int, open_id: String?, cursor: Int): LiveData<FansInfos> {
        viewModelScope.launch {
            when (val result =
                AppSetting.CLIENT_TOKEN?.let {
                    repository?.getFansInfo(
                        it,
                        count,
                        open_id,
                        cursor
                    )
                }) {
                is ApiResult.Success -> {
                    fansList.value = result.data!!
                }
                is ApiResult.Error.ServerError -> {

                }
                is ApiResult.Error.Exception -> {

                }
                else -> {}
            }
        }
        return fansList
    }
}
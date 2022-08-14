package com.qxy.douyinDemo.ui.activity

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import com.bytedance.sdk.open.aweme.authorize.model.Authorization
import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory
import com.bytedance.sdk.open.douyin.DouYinOpenConfig
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi
import com.gyf.immersionbar.ImmersionBar
import com.qxy.douyinDemo.R
import com.qxy.douyinDemo.app.AppSetting
import com.qxy.douyinDemo.base.BaseActivity
import com.qxy.douyinDemo.databinding.ActivityMainBinding
import com.qxy.douyinDemo.mvvm.repository.RepositoryImpl
import com.qxy.douyinDemo.mvvm.viewModel.MainViewModel
import com.qxy.douyinDemo.ui.movieRank.MovieRankActivity

class MainActivity : BaseActivity<RepositoryImpl, MainViewModel, ActivityMainBinding>() {

//    private val mScope =
//        "user_info,im.share,aweme.share,aweme.capture,video.data,video.list,video.search," +
//                "video.search.comment,following.list,fans.list,fans.check,renew_refresh_token," +
//                "data.external.item,discovery.ent,star_top_score_display,star_tops," +
//                "star_author_score_display,data.external.sdk_share,hotsearch," +
//                "data.external.billboard_live,data.external.billboard_hot_video," +
//                "data.external.billboard_music,data.external.billboard_prop," +
//                "data.external.billboard_topicdata.external.billboard_game," +
//                "data.external.billboard_drama,data.external.billboard_car," +
//                "data.external.billboard_amusement,data.external.billboard_cospa," +
//                "data.external.billboard_food,data.external.billboard_travel," +
//                "data.external.billboard_stars,data.external.billboard_sport,trial.whitelist" +
//                "poi.cps.common,micapp.is_legal,incremental_authorization"

    override fun getContextViewId(): Int {
        return R.layout.activity_main
    }

    override fun processLogic() {
        Log.d("MainActivity", "processLogic called!")
    }

    override fun setListener() {

    }

    override fun onClick(view: View?) {
        when (view?.id) {

        }
    }

}
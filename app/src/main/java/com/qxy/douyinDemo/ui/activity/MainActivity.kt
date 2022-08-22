package com.qxy.douyinDemo.ui.activity

import android.util.Log
import android.view.View
import com.qxy.douyinDemo.R
import com.qxy.douyinDemo.base.BaseActivity
import com.qxy.douyinDemo.databinding.ActivityMainBinding
import com.qxy.douyinDemo.mvvm.repository.RepositoryImpl
import com.qxy.douyinDemo.mvvm.viewModel.MainViewModel
<<<<<<< HEAD
=======

>>>>>>> 454a94d8e00ec4cafea05ca1629341a197f30c26
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

<<<<<<< HEAD
    private val mScope =
        "user_info,video.list,trial.whitelist"

    var douYinOpenApi: DouYinOpenApi? = null

    override fun getContextViewId(): Int {
=======
    override fun getContentViewId(): Int {
>>>>>>> 454a94d8e00ec4cafea05ca1629341a197f30c26
        return R.layout.activity_main
    }

    override fun processLogic() {
<<<<<<< HEAD
        AppSetting.context = this
        ImmersionBar.with(this)
            .statusBarDarkFont(true)
            .init()
        DouYinOpenApiFactory.init(DouYinOpenConfig(AppSetting.CLIENT_KEY))
        douYinOpenApi = DouYinOpenApiFactory.create(this)
        sendAuth()
        mViewModel.loginResult.observe(this, Observer {
            AppSetting.OPEN_ID=it.open_id
            Log.d("accessToken", "onCreate: $it.accessToken")
            Log.d("openId", "onCreate: $it.openId")
        })
        mViewModel.clientOauthResult.observe(this) {
            Log.d("client_token", "${it.access_token}")
        }
=======
        Log.d("MainActivity", "processLogic called!")
>>>>>>> 454a94d8e00ec4cafea05ca1629341a197f30c26
    }

    override fun setListener() {

    }

    override fun onClick(view: View?) {
        when (view?.id) {

        }
    }

}
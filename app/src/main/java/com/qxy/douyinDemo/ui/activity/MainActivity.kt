package com.qxy.douyinDemo.ui.activity

import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.bytedance.sdk.open.aweme.authorize.model.Authorization
import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory
import com.bytedance.sdk.open.douyin.DouYinOpenConfig
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi
import com.qxy.douyinDemo.base.BaseActivity
import com.qxy.douyinDemo.mvvm.repository.RepositoryImpl
import com.qxy.douyinDemo.R
import com.qxy.douyinDemo.app.AppSetting
import com.qxy.douyinDemo.databinding.ActivityMainBinding
import com.qxy.douyinDemo.mvvm.viewModel.MainViewModel

class MainActivity : BaseActivity<RepositoryImpl, MainViewModel, ActivityMainBinding>() {

    private val mScope = "user_info"
    var douYinOpenApi: DouYinOpenApi? = null

    override fun getContextViewId(): Int {
        return R.layout.activity_main
    }

    override fun processLogic() {
        DouYinOpenApiFactory.init(DouYinOpenConfig(AppSetting.CLIENT_KEY))
        douYinOpenApi = DouYinOpenApiFactory.create(this)
        sendAuth()
        mViewModel.loginResult.observe(this, Observer {
            Log.d("accessToken", "onCreate: $it.accessToken")
            Log.d("openId", "onCreate: $it.openId")
        })
    }

    override fun setListener() {
        binding.btnGetAccessToken.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_getAccessToken -> {
                val authCode =
                    getSharedPreferences("douyin", Context.MODE_PRIVATE).getString(
                        "authCode",
                        null
                    )
                Log.d("authCode", "onCreate: $authCode")
                authCode?.let {
                    mViewModel.toLogin(it)
                }
            }
        }
    }

    private fun sendAuth(): Boolean? {
        val request = Authorization.Request()
        request.scope = mScope // 用户授权时必选权限
        request.optionalScope0 = "mobile" // 用户授权时可选权限（默认选择）
        //        request.optionalScope0 = mOptionalScope1;    // 用户授权时可选权限（默认不选）
        request.state = "ww" // 用于保持请求和回调的状态，授权请求后原样带回给第三方。
        return douYinOpenApi?.authorize(request) // 优先使用抖音app进行授权，如果抖音app因版本或者其他原因无法授权，则使用wap页授权
    }

}
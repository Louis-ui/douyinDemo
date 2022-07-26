package com.qxy.douyinDemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bytedance.sdk.open.aweme.authorize.model.Authorization
import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory
import com.bytedance.sdk.open.douyin.DouYinOpenConfig
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi
import com.qxy.douyinDemo.app.AppSetting

class MainActivity : AppCompatActivity() {
    private val mScope = "user_info"
    var douYinOpenApi: DouYinOpenApi? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DouYinOpenApiFactory.init(DouYinOpenConfig(AppSetting.CLIENT_KEY))
        douYinOpenApi = DouYinOpenApiFactory.create(this)
        sendAuth()


//        lifecycleScope.launch {
//            when (API.BACKEND_SERVICE.login()) {
//                is ApiResult.Success -> {}
//                is ApiResult.Error.ServerError -> {}
//                is ApiResult.Error.Exception -> {}
//            }
//        }


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
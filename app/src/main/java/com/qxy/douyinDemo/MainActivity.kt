package com.qxy.douyinDemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bytedance.sdk.open.aweme.authorize.model.Authorization
import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory
import com.bytedance.sdk.open.douyin.DouYinOpenConfig
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi
import com.qxy.douyinDemo.app.AppSetting
import com.qxy.douyinDemo.bean.LoginBody
import com.qxy.douyinDemo.network.API
import com.qxy.douyinDemo.network.ApiResult
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val mScope = "user_info"
    var douYinOpenApi: DouYinOpenApi? = null

    private var button: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DouYinOpenApiFactory.init(DouYinOpenConfig(AppSetting.CLIENT_KEY))
        douYinOpenApi = DouYinOpenApiFactory.create(this)
        sendAuth()



        button = findViewById(R.id.btn_getAccessToken)
        button?.setOnClickListener {
            lifecycleScope.launch {
                val authCode =
                    getSharedPreferences("douyin", Context.MODE_PRIVATE).getString("authCode", null)
                Log.d("authCode", "onCreate: $authCode")
                when (val result = authCode?.let {
                    API.BACKEND_SERVICE.getAccessToken(
                        LoginBody(
                            AppSetting.CLIENT_SECRET,
                            it,
                            "authorization_code",
                            AppSetting.CLIENT_KEY
                        )
                    )
                }) {
                    is ApiResult.Success -> {
                        val accessToken = result.data.access_token
                        val openId = result.data.open_id
                        Log.d("accessToken", "onCreate: $accessToken")
                        Log.d("openId", "onCreate: $openId")
                        AppSetting.ACCESS_TOKEN = accessToken
                        AppSetting.OPEN_ID = openId
                    }
                    is ApiResult.Error.ServerError -> {
                        Log.d("auth", "onCreate: fail")
                    }
                    is ApiResult.Error.Exception -> {
                        Log.d("auth", "onCreate: fail")
                    }
                    else -> {}
                }
            }
        }

        val btn_goRank: Button = findViewById(R.id.btn_goMovieRankList)
        btn_goRank.setOnClickListener {
            val intent = Intent(this, MovieRankActivity::class.java)
            startActivity(intent)
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
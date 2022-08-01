package com.qxy.douyinDemo.UI.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.bytedance.sdk.open.aweme.authorize.model.Authorization
import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory
import com.bytedance.sdk.open.douyin.DouYinOpenConfig
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi
import com.qxy.douyinDemo.Base.BaseActivity
import com.qxy.douyinDemo.Base.RepositoryImpl
import com.qxy.douyinDemo.Base.callback
import com.qxy.douyinDemo.R
import com.qxy.douyinDemo.UI.MovieRank.MovieRankActivity
import com.qxy.douyinDemo.app.AppSetting
import com.qxy.douyinDemo.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : BaseActivity<RepositoryImpl, MainViewModel, ActivityMainBinding>() {
    /*  private val mScope = "user_info"
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
          /*     when (val result = authCode?.let {
                    API.BACKEND_SERVICE.getAccessToken(
                        AppSetting.CLIENT_SECRET,
                        it,
                        "authorization_code",
                        AppSetting.CLIENT_KEY
                    )
                }) {
                    is ApiResult.Success -> {
                        val accessToken = result.data?.access_token
                        val openId = result.data?.open_id
                        Log.d("accessToken", "onCreate: $accessToken")
                        Log.d("openId", "onCreate: $openId")
                        AppSetting.ACCESS_TOKEN = accessToken
                        AppSetting.OPEN_ID = openId
                    }
                    is ApiResult.Error.ServerError -> {
                        Log.d("auth", "onCreate: fail ServerError")
                    }
                    is ApiResult.Error.Exception -> {
                        Log.d("auth", "onCreate: fail Exception")
                    }
                    else -> {}
                }*/
                authCode?.let { it ->
                    val impl=RepositoryImpl()
                    impl.getToken(AppSetting.CLIENT_SECRET,
                      it,
                        "authorization_code",
                        AppSetting.CLIENT_KEY).observe(this@MainActivity, Observer {
                        it.handler(object :callback(){
                            override fun success() {
                                val accessToken = it.data?.access_token
                                val openId = it.data?.open_id
                                Log.d("accessToken", "onCreate: $accessToken")
                                Log.d("openId", "onCreate: $openId")
                                AppSetting.ACCESS_TOKEN = accessToken
                                AppSetting.OPEN_ID = openId
                            }
                        })

                    })
                }


//                val result = API.BACKEND_SERVICE.getUserInfo(
//                    mapOf(
//                    "access_token" to "act.1ad9da634b69dda95eabe40508be4d23lWMfDq7JZYaoLoYMpZ3vVq4l5wjr",
//                    "open_id" to "_000MTMjsr8Zy4_37r-hPOx363bNbJ3Uelpl")
//                )
//                when(result){
//                    is ApiResult.Success -> {
//                        Log.d("user", "onCreate: ${result.data.toString()}")}
//                }
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
    }*/
    private val mScope = "user_info"
    var douYinOpenApi: DouYinOpenApi? = null

    private var button: Button? = null
    override fun getContextViewId(): Int {
        return R.layout.activity_main
    }

    override fun processLogic() {
        if (mViewModel !is MainViewModel)
        {
            Log.d("NULL","VIEWMODEL")
        }
        DouYinOpenApiFactory.init(DouYinOpenConfig(AppSetting.CLIENT_KEY))
        douYinOpenApi = DouYinOpenApiFactory.create(this)
        sendAuth()
        button = findViewById(R.id.btn_getAccessToken)
        button?.setOnClickListener {
            lifecycleScope.launch {
                val authCode =
                    getSharedPreferences("douyin", Context.MODE_PRIVATE).getString("authCode", null)
                Log.d("authCode", "onCreate: $authCode")
               authCode?.let {
                    mViewModel.Tologin(
                        AppSetting.CLIENT_SECRET,
                        it,
                        "authorization_code",
                        AppSetting.CLIENT_KEY
                    )?.observe(this@MainActivity, Observer {
                        it.handler(object : callback() {
                            override fun success() {
                                val accessToken = it.data?.access_token
                                val openId = it.data?.open_id
                                Log.d("accessToken", "onCreate: $accessToken")
                                Log.d("openId", "onCreate: $openId")
                                AppSetting.ACCESS_TOKEN = accessToken
                                AppSetting.OPEN_ID = openId
                            }
                        })
                    })
                }
            }
        }

        val btn_goMovieRank: Button = findViewById(R.id.btn_goMovieRankList)
        btn_goMovieRank.setOnClickListener {
            startActivity(Intent(this, MovieRankActivity::class.java))
        }
    }

    override fun setListener() {
    }

    override fun onClick(p0: View?) {

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
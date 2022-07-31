package com.qxy.douyinDemo.base

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType


abstract class BaseActivity<T : BaseModel, vm : BaseViewModel<T>, vdb : ViewDataBinding> :
    AppCompatActivity(), View.OnClickListener {
    protected lateinit var mViewModel: vm
    protected lateinit var binding: vdb

    //获取当前Acyivity 布局文件
    abstract fun getContextViewId(): Int

    //处理逻辑业务
    abstract fun processLogic(): Unit

    //设置所有监听
    abstract fun setListener(): Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getContextViewId())
        binding.lifecycleOwner = this
        createViewModel()
        processLogic()
        setListener()
    }

    private fun createViewModel() {
        val vmClass: Class<vm> =
            (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[1] as Class<vm>
        mViewModel = ViewModelProvider(this).get(vmClass) as vm


    }

    public fun getContext(): Context {
        return this
    }

    //快速获取textView或EditText上文字内容
    public fun getStringByUI(view: View): String {
        if (view is EditText) {
            return view.text.toString().trim { it <= ' ' }
        } else if (view is TextView) {
            return view.text.toString().trim { it <= ' ' }
        }
        return ""


    }
}


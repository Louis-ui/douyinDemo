package com.qxy.douyinDemo.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

abstract class BaseFragment<T : BaseModel, vm : BaseViewModel<T>, vdb : ViewDataBinding> :
    Fragment(), View.OnClickListener {
    //获取当前activity布局文件
    protected abstract fun getContentViewId(): Int

    //处理逻辑业务
    protected abstract fun processLogic(savedInstanceState: Bundle?)

    //所有监听放这里
    protected abstract fun setListener()
    protected var mViewModel: vm? = null
    protected var mContentView: View? = null
    protected lateinit var binding: vdb


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 避免多次从xml中加载布局文件
        if (mContentView == null) {
            binding = DataBindingUtil.inflate(inflater, getContentViewId(), null, false)
            mContentView = binding.root
            binding.lifecycleOwner = this
            createViewModel()
            setListener()
            processLogic(savedInstanceState)
        } else {
            val parent = mContentView!!.parent as ViewGroup
            parent?.removeView(mContentView)
        }
        return mContentView
    }

    private fun createViewModel() {
        val vmClass: Class<vm> =
            (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[1] as Class<vm>
        mViewModel = ViewModelProvider(this).get(vmClass) as vm
    }

    open fun getStringByUI(view: View?): String? {
        if (view is EditText) {
            return view.text.toString().trim { it <= ' ' }
        } else if (view is TextView) {
            return view.text.toString().trim { it <= ' ' }
        }
        return ""
    }
}
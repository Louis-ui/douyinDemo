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

/**
 *  A base Activity class for all in the project, inherit from AppCompatActivity and
 *  implement interface View.OnClickListener
 *  @param T BaseModel, a base class for Model in MVVM architecture
 *  @param vm BaseViewModel, a base class for ViewModel in MVVM architecture
 *  @param vdm ViewDataBinding, an auto-generated class when xml file use <data> element
 *  @property mViewModel View Model instance of activity
 *  @property binding Data Binding instance of activity
 *  @author SunMoon, louis-ui
 *  */
abstract class BaseActivity<T : BaseModel, vm : BaseViewModel<T>, vdb : ViewDataBinding> :
    AppCompatActivity(), View.OnClickListener {
    protected lateinit var mViewModel: vm
    protected lateinit var binding: vdb

    /**
     * Get current activity's layout file
     * @return content view id, like R.layout.xxxxxx
     */
    abstract fun getContentViewId(): Int

    /**
     * Process business logic
     */
    abstract fun processLogic(): Unit

    /**
     * Set all listener, like onClick event for Button
     */
    abstract fun setListener(): Unit

    /**
     * On this method, dataBinding and lifecycle will set first, and then execute method
     * createViewModel(), processLogic() and setListener(). So you have no need to override
     * but just implement some of these abstract methods before.
     * @param savedInstanceState The savedInstanceState is a reference to a Bundle object
     * that is passed into the onCreate method of every Android Activity.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getContentViewId())
        binding.lifecycleOwner = this
        createViewModel()
        processLogic()
        setListener()
    }

    /**
     * Create ViewModel instance for current activity and store&get data from it
     */
    private fun createViewModel() {
        val vmClass: Class<vm> =
            (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[1] as Class<vm>
        mViewModel = ViewModelProvider(this)[vmClass]
    }

    /**
     * Get activity context from this method
     */
    fun getContext(): Context = this

    /**
     * Quickly get trimmed text from TextView or EditText, and return empty text when
     * view is not EditText/TextView
     * @param view the TextView/EditText that you want to get string
     * @return text in the TextView/EditText
     */
    fun getStringByUI(view: View): String {
        if (view is EditText) {
            return view.text.toString().trim { it <= ' ' }
        } else if (view is TextView) {
            return view.text.toString().trim { it <= ' ' }
        }
        return ""
    }
}


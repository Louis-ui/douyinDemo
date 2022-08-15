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

/** A base Fragment class for all in the project, inherit from Fragment and implement
 * interface View.OnClickListener
 * @param T BaseModel, a base class for Model in MVVM architecture
 * @param vm BaseViewModel, a base class for ViewModel in MVVM architecture
 * @param vdb ViewDataBinding, an auto-generated class when xml file use <data> element
 * @property mViewModel View Model instance of activity
 * @property mContentView Current layout object
 * @property binding Data Binding instance of activity
 * @author SunMooN, louis-ui
 */
abstract class BaseFragment<T : BaseModel, vm : BaseViewModel<T>, vdb : ViewDataBinding> :
    Fragment(), View.OnClickListener {
    protected var mViewModel: vm? = null
    protected var mContentView: View? = null
    protected lateinit var binding: vdb

    /**
     * Get current fragment's layout file
     * @return layout id, like R.layout.xxxxxx
     */
    protected abstract fun getContentViewId(): Int

    /**
     * Process business logic
     * @param savedInstanceState The savedInstanceState is a reference to a Bundle object
     * that is passed into the onCreate method of every Android Activity.
     */
    protected abstract fun processLogic(savedInstanceState: Bundle?)

    /**
     * Set all listener, like onClick event for Button
     */
    protected abstract fun setListener()

    /**
     * Create ViewModel instance for current activity and store&get data from it
     */
    private fun createViewModel() {
        val vmClass: Class<vm> =
            (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[1] as Class<vm>
        mViewModel = ViewModelProvider(this).get(vmClass)
    }

    /**
     * On this method, dataBinding and livecycle will set first, and then execute method
     * createViewModel(), setListener() and processLogic(). So you have no need to override
     * but just implement som of these abstract method before.
     * @param inflater The LayoutInflater object that can be used to inflate any views in
     * the fragment
     * @param container If non-null, this is the parent view that the fragment's UI should be
     * attached to. The fragment should not add the view itself, but this can be used to
     * generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a
     * previous saved state as given here.
     * @return Return the View for the fragment's UI.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Avoid layout files loaded multiple times
        if (mContentView == null) {
            binding = DataBindingUtil.inflate(inflater, getContentViewId(), null, false)
            mContentView = binding.root
            binding.lifecycleOwner = this
            createViewModel()
            setListener()
            processLogic(savedInstanceState)
        } else {
            val parent = mContentView!!.parent as ViewGroup
            parent.removeView(mContentView)
        }
        return mContentView
    }

    /**
     * Quickly get trimmed text from TextView or EditText, and return empty text when
     * view is not EditText/TextView
     * @param view the TextView/EditText that you want to get string
     * @return text in the TextView/EditText
     */
    open fun getStringByUI(view: View?): String? {
        if (view is EditText) {
            return view.text.toString().trim { it <= ' ' }
        } else if (view is TextView) {
            return view.text.toString().trim { it <= ' ' }
        }
        return ""
    }
}
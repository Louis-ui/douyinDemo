package com.qxy.douyinDemo.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.qxy.douyinDemo.mvvm.repository.RepositoryImpl

/**
 * A base ViewModel class for all in the project.
 * @param T Model class
 * @property repository Model instance
 * @author SunMooN, louis-ui
 */
open class BaseViewModel<T : BaseModel?>(application: Application) :
    AndroidViewModel(application) {
    var repository: T? = null
        private set

    /**
     * Instantiating the Model instance
     */
    private fun createRepository() {
        if (repository == null) {
            repository = RepositoryImpl() as T
        }
    }

    init {
        createRepository()
    }
}
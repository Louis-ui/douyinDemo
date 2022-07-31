package com.qxy.douyinDemo.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.qxy.douyinDemo.mvvm.repository.RepositoryImpl

open class BaseViewModel<T : BaseModel?>(application: Application) :
    AndroidViewModel(application) {
    var repository: T? = null
        private set

    private fun createRepository() {
        if (repository == null) {
            repository = RepositoryImpl() as T
        }
    }

    override fun onCleared() {
        super.onCleared()
    }

    init {
        createRepository()
    }
}
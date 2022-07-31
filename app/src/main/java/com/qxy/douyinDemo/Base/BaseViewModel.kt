package com.qxy.douyinDemo.Base

import android.app.Application
import androidx.lifecycle.AndroidViewModel

open class BaseViewModel<T : BaseModel?>(application: Application) :
    AndroidViewModel(application) {
    var repository: T? = null
        private set
    fun createRepository() {
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
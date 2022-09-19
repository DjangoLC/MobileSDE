package com.example.itijuanatest.utils

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher

open class BaseViewModel(uiDispatcher: CoroutineDispatcher) : ViewModel(),
    Scope by Scope.Impl(uiDispatcher) {

    init {
        initScope()
    }

    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }

}
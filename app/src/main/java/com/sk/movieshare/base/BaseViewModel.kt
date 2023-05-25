package com.sk.movieshare.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel  @Inject constructor(): ViewModel(){
    var showLoadingLiveData: MutableLiveData<Boolean> = MutableLiveData()
        private set

    private var handleErrorLiveData: MutableLiveData<Throwable> = MutableLiveData()

    override fun onCleared() {
        super.onCleared()
    }

    fun showLoading() {
        showLoadingLiveData.value = true
    }

    fun hideLoading() {
        showLoadingLiveData.value = false
    }

    fun handleError(throwable: Throwable) {
        handleErrorLiveData.value = throwable
    }

    fun getHandleErrorEvent(): LiveData<Throwable> {
        return handleErrorLiveData
    }
}
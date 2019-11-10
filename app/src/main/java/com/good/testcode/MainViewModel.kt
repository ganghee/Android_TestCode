package com.good.testcode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val helloText = MutableLiveData<String>()

    fun getText() = helloText

}
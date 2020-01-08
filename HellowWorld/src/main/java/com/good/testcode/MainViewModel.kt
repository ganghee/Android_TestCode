package com.good.testcode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class MainViewModel : ViewModel() {

    val helloText = MutableLiveData<String>().apply {
        value = "Hello World!"
    }
}
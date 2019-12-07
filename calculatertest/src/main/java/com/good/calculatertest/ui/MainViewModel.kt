package com.good.calculatertest.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val firstNum = MutableLiveData<String>().apply {
        value = "0"
    }
    val secondNum = MutableLiveData<String>().apply {
        value = "0"
    }
    val result = MutableLiveData<String>().apply {
        value = "0"
    }

    val indicator = MutableLiveData<String>().apply { value = "+" }

    fun calc(op: String) {
        if (firstNum.value.isNullOrBlank() || secondNum.value.isNullOrBlank()) {
            return result.postValue("0")
        }
        indicator.postValue(op)
        result.postValue(
            when (op) {
                "+" -> firstNum.value?.toInt()?.plus(secondNum.value?.toInt()!!).toString()
                "-" -> firstNum.value?.toInt()?.minus(secondNum.value?.toInt()!!).toString()
                "*" -> firstNum.value?.toInt()?.times(secondNum.value?.toInt()!!).toString()
                "/" -> if (secondNum.value?.toInt() == 0) {
                    "0"
                } else {
                    firstNum.value?.toInt()?.div(secondNum.value?.toInt()!!).toString()
                }
                else -> "0"
            }
        )
    }
}
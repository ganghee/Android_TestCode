package com.good.calculatertest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val firstNum = MutableLiveData<String>()
    val secondNum = MutableLiveData<String>()
    val result = MutableLiveData<String>()
    val indicator = MutableLiveData<String>()

    fun calc(op: Char) {
        indicator.postValue(op.toString())
        result.postValue(
            when (op) {
                '+' -> (firstNum.value?.toInt()?.plus(secondNum.value?.toInt()!!)).toString()
                '-' -> (firstNum.value?.toInt()?.minus(secondNum.value?.toInt()!!)).toString()
                '*' -> (firstNum.value?.toInt()?.times(secondNum.value?.toInt()!!)).toString()
                '/' -> (firstNum.value?.toInt()?.div(secondNum.value?.toInt()!!)).toString()
                else -> ""
            }
        )
    }
}
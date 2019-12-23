package com.good.logintest.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.good.logintest.delegate.ContextDelegate
import com.good.logintest.delegate.ContextDelegateImpl
import com.good.logintest.util.isValidEmail
import com.good.logintest.util.isValidPassword

class LoginViewModel(private val contextDelegate: ContextDelegate) : ViewModel() {
    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()
    private fun getString(resId: Int) = contextDelegate.getString(resId)

    val isWrongEmailVisible = MutableLiveData<Boolean>().apply {
        value = false
    }
    val isWrongPasswordVisible = MutableLiveData<Boolean>().apply {
        value = false
    }
    val isButtonSelected = MutableLiveData<Boolean>().apply {
        value = false
    }
    val nextState = MutableLiveData<NextState>()


    fun isLoginSelected() {
        isButtonSelected.value = !id.value.isNullOrEmpty() && !pw.value.isNullOrEmpty()
    }

    fun isEmail(id: String) {
        isWrongEmailVisible.value = !id.isValidEmail()
    }

    fun isMoreSix(pw: String) {
        isWrongPasswordVisible.value = !pw.isValidPassword()
    }

    fun onLoginClick() {
        if (id.value.isNullOrBlank() || pw.value.isNullOrBlank()){
            nextState.value = NextState.아이디와_패스워드를_입력해주세요
        }
        else if (!id.value.isNullOrBlank() && !pw.value.isNullOrBlank() &&
            isWrongEmailVisible.value == false && isWrongPasswordVisible.value == false
        ) {
            nextState.value = NextState.로그인이_되었습니다
        } else {
            nextState.value = NextState.아이디_또는_패스워드가_옳바르지_않습니다
        }
    }

    fun onSignUpClick() {
        nextState.value = NextState.회원가입창으로_넘어갑니다
    }

    enum class NextState {
        아이디_또는_패스워드가_옳바르지_않습니다, 로그인이_되었습니다, 회원가입창으로_넘어갑니다, 아이디와_패스워드를_입력해주세요
    }

}
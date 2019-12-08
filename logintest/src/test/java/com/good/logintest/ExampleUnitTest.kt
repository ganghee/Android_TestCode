package com.good.logintest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.good.logintest.ui.LoginViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private lateinit var loginViewModel: LoginViewModel

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setupViewModel() {
        loginViewModel = LoginViewModel()
    }

    @Test
    fun `(given)id,pw 값이 입력되지 않고(when)버튼을 눌렀을 때(then) 버튼이 활성화 되지 않는다`(){
        loginViewModel.apply {
            id.postValue("")
            pw.postValue("")
            isLoginSelected()
            assertEquals(isButtonSelected.value,false)
        }
    }

    @Test
    fun `(given)id 입력 형식이 아니고(when)버튼을 눌렀을 때(then)아이디 또는 패스워드가 옳바르지 않다고 나온다`(){
        loginViewModel.apply {
            id.postValue("1111")
            pw.postValue("123456")
            isEmail(id.value.toString())
            onLoginClick()
            assertEquals(nextState.value, LoginViewModel.NextState.아이디_또는_패스워드가_옳바르지_않습니다)
        }
    }
}

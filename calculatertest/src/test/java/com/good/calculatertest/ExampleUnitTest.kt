package com.good.calculatertest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.good.calculatertest.ui.MainViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private lateinit var mainViewModel: MainViewModel

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setupViewModel() {
        mainViewModel = MainViewModel()
    }

    @Test
    fun `(given)2개의 숫자가 입력되고 (when)text창을 바꿀 때 버튼을 누르면 (then)결과창이 바뀐다(더하기)`() {
        mainViewModel.firstNum.postValue("3")
        mainViewModel.secondNum.postValue("5")
        mainViewModel.calc("+")
        assertEquals(mainViewModel.result.value, "8")
    }

    @Test
    fun `(given)2개의 숫자가 입력되고 (when)text창을 바꿀 때 버튼을 누르면 (then)결과창이 바뀐다(빼기)`() {
        mainViewModel.firstNum.postValue("5")
        mainViewModel.secondNum.postValue("3")
        mainViewModel.calc("-")
        assertEquals(mainViewModel.result.value, "2")

    }

    @Test
    fun `(given)2개의 숫자가 입력되고 (when)text창을 바꿀 때 버튼을 누르면 (then)결과창이 바뀐다(곱하기)`() {
        mainViewModel.firstNum.postValue("5")
        mainViewModel.secondNum.postValue("3")
        mainViewModel.calc("*")
        assertEquals(mainViewModel.result.value, "15")
    }

    @Test
    fun `(given)2개의 숫자가 입력되고 (when)text창을 바꿀 때 버튼을 누르면 (then)결과창이 바뀐다(나누기)`() {
        mainViewModel.firstNum.postValue("5")
        mainViewModel.secondNum.postValue("3")
        mainViewModel.calc("/")
        assertEquals(mainViewModel.result.value, "1")
    }
}

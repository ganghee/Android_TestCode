package com.good.testcode

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {
    private lateinit var mainViewModel: MainViewModel

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setupViewModel(){
        mainViewModel = MainViewModel()
    }

    @Test
    fun 버튼을누르면_메인화면에서_hellowWorld가나타난다() {
        assertThat(mainViewModel.getText().value, `is`("Hello World"))
    }

}
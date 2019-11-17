package com.good.myweather.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.good.myweather.data.source.WeatherRepository
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {
    private lateinit var mainViewModel: MainViewModel
    private val repository = WeatherRepository()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setupViewModel() {
        mainViewModel = MainViewModel(repository)
    }

    @Test
    fun 오픈api를통해데이터를가져오면_화면을실행할때_갯수가일치하는지확인() {
        mainViewModel.weatherList.observeForever {
            assertThat(it.list.length(), `is`(5))
        }
    }
}
package com.good.myweather.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.good.myweather.data.source.WeatherRepository
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class MainViewModelTest {
    private lateinit var mainViewModel: MainViewModel
    private val repository = Mockito.mock(WeatherRepository::class.java)

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    //private val observer: Observer<WeatherResponse> = mock()

    @Before
    fun setupViewModel() {
        mainViewModel = MainViewModel(repository)
    }

    @Test
    fun 오픈api를통해데이터를가져오면_화면을실행할때_갯수가일치하는지확인() {

        mainViewModel.weatherList.observeForever {
            assertEquals(6, it.list)
        }
    }
}
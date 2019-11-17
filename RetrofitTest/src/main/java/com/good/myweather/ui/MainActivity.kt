package com.good.myweather.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.good.myweather.adapter.MainAdapter
import com.good.myweather.data.source.WeatherRepository
import com.good.myweather.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val mainAdapter = MainAdapter()
    private val mainViewModel by lazy { MainViewModel(repository = WeatherRepository()) }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, com.good.myweather.R.layout.activity_main)

        initViewModel()
        mainViewModel.getWeather()

        mainViewModel.weatherList.observe(this, Observer {
            if (it.list.isNotEmpty()) {
                progress_circular.isVisible = false
                mainAdapter.setData(it.list)
            }
        })
    }

    private fun initViewModel() {
        binding.run {
            vm = mainViewModel
            recycler_main.adapter = mainAdapter
        }
    }
}

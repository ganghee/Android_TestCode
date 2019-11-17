package com.good.myweather.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.good.myweather.data.source.WeatherRepository
import com.good.myweather.data.source.WeatherResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(private val repository: WeatherRepository) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    val weatherList = MutableLiveData<WeatherResponse>()

    @SuppressLint("CheckResult")
    fun getWeather() {
        repository.getWeather()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                weatherList.postValue(it)
            }, {
                showFailedWeatherList()
            }).also {
                compositeDisposable.add(it)
            }
    }

    private fun showFailedWeatherList() {
        Log.d("Weather", "Weather is not show")
    }

    override fun onCleared() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
        super.onCleared()
    }
}
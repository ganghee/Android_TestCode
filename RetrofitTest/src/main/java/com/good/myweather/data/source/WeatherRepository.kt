package com.good.myweather.data

import com.good.myweather.data.remote.WeatherRemoteDataSource
import io.reactivex.Single

class WeatherRepository {
    fun getWeather(): Single<WeatherResponse> =
        WeatherRemoteDataSource.getWeatherResponse()

}
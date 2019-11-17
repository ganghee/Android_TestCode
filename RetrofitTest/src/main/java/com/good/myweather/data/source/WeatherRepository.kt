package com.good.myweather.data.source

import com.good.myweather.data.source.remote.WeatherRemoteDataSource
import io.reactivex.Single

class WeatherRepository {
    fun getWeather(): Single<WeatherResponse> =
        WeatherRemoteDataSource.getWeatherResponse()

}
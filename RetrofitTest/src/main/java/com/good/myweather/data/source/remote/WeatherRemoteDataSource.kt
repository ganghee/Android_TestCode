package com.good.myweather.data.remote

import com.good.myweather.data.WeatherResponse
import com.good.myweather.data.WeatherService
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object WeatherRemoteDataSource {
    private val retrofit: WeatherService = Retrofit.Builder()
        .baseUrl("https://samples.openweathermap.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(WeatherService::class.java)

    fun getWeatherResponse(): Single<WeatherResponse> =
        retrofit.getWeathers()
            .subscribeOn(Schedulers.io())
}

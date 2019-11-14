package com.good.myweather.data

import io.reactivex.Single
import retrofit2.http.GET

//daily?id=524901&appid=b1b15e88fa797225412429c1c50c122a1/

interface WeatherService {
    @GET("data/2.5/forecast/daily?id=524901&appid=b1b15e88fa797225412429c1c50c122a1/")
    fun getWeathers(): Single<WeatherResponse>
}
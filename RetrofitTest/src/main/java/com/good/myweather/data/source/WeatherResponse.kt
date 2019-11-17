package com.good.myweather.data.source


import com.good.myweather.data.City
import com.good.myweather.data.X
import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("city")
    val city: City,
    @SerializedName("cnt")
    val cnt: Int,
    @SerializedName("cod")
    var cod: String,
    @SerializedName("list")
    val list: List<X>,
    @SerializedName("message")
    val message: Int
)
package com.good.myweather.repository.data


import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("country")
    val country: String,
    @SerializedName("geoname_id")
    val geonameId: Int,
    @SerializedName("iso2")
    val iso2: String,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double,
    @SerializedName("name")
    val name: String,
    @SerializedName("population")
    val population: Int,
    @SerializedName("type")
    val type: String
)
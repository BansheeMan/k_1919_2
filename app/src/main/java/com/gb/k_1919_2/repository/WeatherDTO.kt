package com.gb.k_1919_2.repository


import com.google.gson.annotations.SerializedName

data class WeatherDTO(
    @SerializedName("fact")
    val factDTO: FactDTO,
    @SerializedName("forecast")
    val forecastDTO: ForecastDTO,
    @SerializedName("info")
    val infoDTO: InfoDTO,
    @SerializedName("now")
    val now: Int,
    @SerializedName("now_dt")
    val nowDt: String
)
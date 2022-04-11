package com.gb.k_1919_2.repository

fun interface OnServerResponse {
    fun onResponse(weatherDTO: WeatherDTO)
}
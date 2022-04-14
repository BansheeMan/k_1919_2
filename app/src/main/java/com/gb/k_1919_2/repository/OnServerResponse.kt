package com.gb.k_1919_2.repository

import com.gb.k_1919_2.repository.dto.WeatherDTO

fun interface OnServerResponse {
    fun onResponse(weatherDTO: WeatherDTO)
}
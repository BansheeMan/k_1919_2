package com.gb.k_1919_2.repository

import com.gb.k_1919_2.repository.dto.WeatherDTO
import com.gb.k_1919_2.viewmodel.DetailsViewModel


interface DetailsRepositoryAdd {
    fun addWeather(weather: Weather)
}
package com.gb.k_1919_2.repository

import com.gb.k_1919_2.repository.dto.WeatherDTO
import com.gb.k_1919_2.viewmodel.DetailsViewModel
import com.gb.k_1919_2.viewmodel.HistoryViewModel


interface DetailsRepositoryAll {
    fun getAllWeatherDetails(callback: HistoryViewModel.CallbackForAll)
}
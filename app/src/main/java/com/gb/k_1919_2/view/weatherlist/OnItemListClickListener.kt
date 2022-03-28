package com.gb.k_1919_2.view.weatherlist

import com.gb.k_1919_2.repository.Weather

interface OnItemListClickListener {
    fun onItemClick(weather: Weather)
}
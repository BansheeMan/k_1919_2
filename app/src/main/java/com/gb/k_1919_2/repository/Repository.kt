package com.gb.k_1919_2.repository

interface Repository {
    fun getWeatherFromServer():Weather
    fun getWeatherFromLocalStorage():Weather
}
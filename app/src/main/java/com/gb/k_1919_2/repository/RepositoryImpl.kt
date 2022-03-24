package com.gb.k_1919_2.repository

class RepositoryImpl:Repository {
    override fun getWeatherFromServer():Weather {
        Thread.sleep(2000L) // эмуляция сетевого запроса
        return Weather()// эмуляция ответа
    }

    override fun getWeatherFromLocalStorage():Weather {
        Thread.sleep(20L) // эмуляция запроса локального
        return Weather()// эмуляция ответа
    }
}
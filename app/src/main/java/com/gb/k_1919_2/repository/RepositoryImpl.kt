package com.gb.k_1919_2.repository

class RepositoryImpl:Repository {
    override fun getWeatherFromServer():Weather {
        Thread.sleep(2000L) // эмуляция сетевого запроса
        return Weather()// эмуляция ответа
    }

    override fun getWorldWeatherFromLocalStorage():List<Weather> {
        return getWorldCities()// эмуляция ответа
    }
    override fun getRussianWeatherFromLocalStorage():List<Weather> {
        return getRussianCities() // эмуляция ответа
    }
}
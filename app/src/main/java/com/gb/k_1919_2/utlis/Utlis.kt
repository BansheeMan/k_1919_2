package com.gb.k_1919_2.utlis

import com.gb.k_1919_2.repository.Weather
import com.gb.k_1919_2.repository.dto.FactDTO
import com.gb.k_1919_2.repository.dto.WeatherDTO
import com.gb.k_1919_2.repository.getDefaultCity


const val KEY_BUNDLE_WEATHER = "weather"
const val YANDEX_DOMAIN = "https://api.weather.yandex.ru/"
const val YANDEX_DOMAIN_HARD_MODE = "http://212.86.114.27/"
const val YANDEX_ENDPOINT = "v2/informers?"
const val YANDEX_API_KEY = "X-Yandex-API-Key"
const val KEY_BUNDLE_LAT = "lat1"
const val KEY_BUNDLE_LON = "lon1"
const val KEY_BUNDLE_SERVICE_BROADCAST_WEATHER = "weather_s_b"
const val KEY_WAVE_SERVICE_BROADCAST = "myaction_way"
const val KEY_BUNDLE_SERVICE_MESSAGE = "key2"
const val KEY_BUNDLE_ACTIVITY_MESSAGE = "key1"
const val KEY_WAVE = "myaction"
class Utlis {
}

fun convertDtoToModel(weatherDTO: WeatherDTO): Weather {
    val fact: FactDTO = weatherDTO.factDTO
    return (Weather(getDefaultCity(), fact.temperature, fact.feelsLike))
}

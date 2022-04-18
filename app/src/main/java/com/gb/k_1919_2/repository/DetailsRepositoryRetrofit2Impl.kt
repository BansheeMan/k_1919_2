package com.gb.k_1919_2.repository

import com.gb.k_1919_2.BuildConfig
import com.gb.k_1919_2.repository.dto.WeatherDTO
import com.gb.k_1919_2.utlis.YANDEX_DOMAIN
import com.gb.k_1919_2.utlis.convertDtoToModel
import com.gb.k_1919_2.viewmodel.DetailsViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class DetailsRepositoryRetrofit2Impl:DetailsRepository {
    override fun getWeatherDetails(city: City, callbackMy: DetailsViewModel.Callback) {
        val weatherAPI = Retrofit.Builder().apply {
            baseUrl(YANDEX_DOMAIN)
            addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        }.build().create(WeatherAPI::class.java)

        // val response = weatherAPI.getWeather(BuildConfig.WEATHER_API_KEY,city.lat,city.lon).execute() можно так (синхронно)
        weatherAPI.getWeather(BuildConfig.WEATHER_API_KEY,city.lat,city.lon).enqueue(object :Callback<WeatherDTO>{ // (асинхронно)
            override fun onResponse(call: Call<WeatherDTO>, response: Response<WeatherDTO>) {
                if(response.isSuccessful){
                    response.body()?.let {
                        callbackMy.onResponse(convertDtoToModel(it))
                    }
                }
            }
            override fun onFailure(call: Call<WeatherDTO>, t: Throwable) {
               // TODO HW
            }
        })
    }
}
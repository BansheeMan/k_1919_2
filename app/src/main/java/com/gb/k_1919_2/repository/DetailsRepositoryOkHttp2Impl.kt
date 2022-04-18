package com.gb.k_1919_2.repository

import com.gb.k_1919_2.BuildConfig
import com.gb.k_1919_2.repository.dto.WeatherDTO
import com.gb.k_1919_2.utlis.YANDEX_API_KEY
import com.gb.k_1919_2.utlis.YANDEX_DOMAIN
import com.gb.k_1919_2.utlis.YANDEX_ENDPOINT
import com.gb.k_1919_2.utlis.convertDtoToModel
import com.gb.k_1919_2.viewmodel.DetailsViewModel
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

import java.io.IOException

class DetailsRepositoryOkHttp2Impl:DetailsRepository {
    override fun getWeatherDetails(city: City,callback: DetailsViewModel.Callback) {
        val client = OkHttpClient()
        val builder = Request.Builder()
        builder.addHeader(YANDEX_API_KEY, BuildConfig.WEATHER_API_KEY)
        builder.url("$YANDEX_DOMAIN${YANDEX_ENDPOINT}lat=${city.lat}&lon=${city.lon}")
        val request = builder.build()
        val call = client.newCall(request)
        Thread{
            val response = call.execute()
            if(response.isSuccessful){
                val serverResponse = response.body()!!.string()
                val weatherDTO: WeatherDTO = Gson().fromJson(serverResponse, WeatherDTO::class.java)
                val weather = convertDtoToModel(weatherDTO)
                weather.city = city
                callback.onResponse(weather)
            }else{
                //TODO HW
            }
        }.start()
    }
}
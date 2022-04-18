package com.gb.k_1919_2.repository

import android.util.Log
import com.gb.k_1919_2.repository.citydto.GeoObjectCollection
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class CitiesRepositoryRetrofit2Impl : CitiesRepository {
    override fun getCityList() {
        val cityAPI = Retrofit.Builder().apply {
            baseUrl("https://geocode-maps.yandex.ru/")
            ///client(createOkHttpClient(WeatherApiInterceptor()))
            addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        }.build().create(CityAPI::class.java)

        // val response = weatherAPI.getWeather(BuildConfig.WEATHER_API_KEY,city.lat,city.lon).execute() можно так (синхронно)
        cityAPI.getCity().enqueue(object : Callback<GeoObjectCollection> { // (асинхронно)
            override fun onResponse(
                call: Call<GeoObjectCollection>,
                response: Response<GeoObjectCollection>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        //Log.d("@@@",it.response.geoObjectCollection.metaDataProperty.geocoderResponseMetaData.())
                        val cities = it.response.geoObjectCollection.featureMember
                        val pos = cities[0].geoObject.point.pos.split(" ")
                        val lat = pos[0]
                        val lon = pos[1]
                        cities.forEach { member ->
                            Log.d("@@@", member.toString())
                        }
                    }
                } else {

                }
            }

            override fun onFailure(call: Call<GeoObjectCollection>, t: Throwable) {
                //Log.d("@@@",t)
            }
        })
    }

    private fun createOkHttpClient(interceptor: Interceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor)
        httpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        return httpClient.build()
    }


    inner class WeatherApiInterceptor : Interceptor {

        //@Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
            return chain.proceed(chain.request())
        }
    }


}
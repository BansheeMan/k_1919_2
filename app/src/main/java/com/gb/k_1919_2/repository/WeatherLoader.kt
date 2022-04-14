package com.gb.k_1919_2.repository

import android.os.Handler
import android.os.Looper
import com.gb.k_1919_2.BuildConfig
import com.gb.k_1919_2.repository.dto.WeatherDTO
import com.gb.k_1919_2.utlis.YANDEX_API_KEY
import com.gb.k_1919_2.utlis.YANDEX_DOMAIN
import com.gb.k_1919_2.utlis.YANDEX_PATH

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class WeatherLoader(
    private val onServerResponseListener: OnServerResponse,
    private val onErrorListener: OnServerResponseListener
) {

    fun loadWeather(lat: Double, lon: Double) {
        val urlText =
            "$YANDEX_DOMAIN${YANDEX_PATH}lat=$lat&lon=$lon" //TODO HW выносим https://api.weather.yandex.ru/v2/informers? в Utlis.kt константы
        //val urlText = "http://212.86.114.27/v2/informers?lat=$lat&lon=$lon"
        val uri = URL(urlText)

        Thread {
            val urlConnection: HttpURLConnection =
                (uri.openConnection() as HttpURLConnection).apply {
                    connectTimeout = 1000 // set под капотом
                    //val r= readTimeout // get под капотом
                    readTimeout = 1000 // set под капотом
                    addRequestProperty(YANDEX_API_KEY, BuildConfig.WEATHER_API_KEY)
                }
            try {
//val urlConnection: HttpsURLConnection = (uri.openConnection() as HttpsURLConnection).apply { для ленивых
                Thread.sleep(500)
                val headers = urlConnection.headerFields
                val responseCode = urlConnection.responseCode
                val responseMessage = urlConnection.responseMessage

                val serverside = 500..599
                val clientside = 400..499
                val responseOk = 200..299
                when (responseCode) {
                    in serverside -> {
                    }
                    in clientside -> {
                    }
                    in responseOk -> {
                        val buffer = BufferedReader(InputStreamReader(urlConnection.inputStream))
                        //val result = (buffer)
                        val weatherDTO: WeatherDTO = Gson().fromJson(buffer, WeatherDTO::class.java)
                        Handler(Looper.getMainLooper()).post {
                            onServerResponseListener.onResponse(weatherDTO)
                        }
                    }
                }


                // TODO  HW "что-то пошло не так" Snackbar?


            } catch (e: JsonSyntaxException) {

            } finally {
                urlConnection.disconnect()
            }
            // поток закрывается
        }.start()


    }

}
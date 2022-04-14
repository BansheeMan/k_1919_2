package com.gb.k_1919_2.repository

import android.os.Handler
import android.os.Looper
import com.gb.k_1919_2.BuildConfig

import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class WeatherLoader(
    private val onServerResponseListener: OnServerResponse,
    private val onErrorListener: OnServerResponseListener
) {

    fun loadWeather(lat: Double, lon: Double) {
        val urlText = "https://api.weather.yandex.ru/v2/informers?lat=$lat&lon=$lon"
        //val urlText = "http://212.86.114.27/v2/informers?lat=$lat&lon=$lon"
        val uri = URL(urlText)

        Thread {
            //val urlConnection: HttpsURLConnection = (uri.openConnection() as HttpsURLConnection).apply { для ленивых
            val urlConnection: HttpURLConnection =
                (uri.openConnection() as HttpURLConnection).apply {
                    connectTimeout = 1000 // set под капотом
                    //val r= readTimeout // get под капотом
                    readTimeout = 1000 // set под капотом
                    addRequestProperty("X-Yandex-API-Key", BuildConfig.WEATHER_API_KEY)
                }
            Thread.sleep(500);
            val headers = urlConnection.headerFields
            val responseCode = urlConnection.responseCode
            val responseMessage = urlConnection.responseMessage

            // TODO  HW  val serverside =??..?? //??
            // TODO  HW  val clientside =??..?? // TODO  HW ??
            // TODO  HW  val responseOk =??..?? // TODO  HW ??

            /*if(responseCode in serverside){
                // TODO  HW "что-то пошло не так" на стороне сервера Snackbar?
                onErrorListener.onError(AppError.Error1) // поток не тот?
            }else if(responseCode in clientside){
                // TODO  HW "что-то пошло не так" на стороне клиента Snackbar?
            }else if(responseCode in responseOk){

            }*/

            val buffer = BufferedReader(InputStreamReader(urlConnection.inputStream))
            //val result = (buffer)
            val weatherDTO: WeatherDTO = Gson().fromJson(buffer, WeatherDTO::class.java)
            Handler(Looper.getMainLooper()).post {
                onServerResponseListener.onResponse(weatherDTO)
            }


            // TODO  HW "что-то пошло не так" Snackbar?
            // TODO  HW disconnect() finally?


            // поток закрывается
        }.start()


    }

}
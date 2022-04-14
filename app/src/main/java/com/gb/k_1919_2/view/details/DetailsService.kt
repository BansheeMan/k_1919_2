package com.gb.k_1919_2.view.details

import android.app.IntentService
import android.content.Intent
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.gb.k_1919_2.BuildConfig
import com.gb.k_1919_2.repository.dto.WeatherDTO
import com.gb.k_1919_2.utlis.*
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class DetailsService(val name: String = "") : IntentService(name) {
    override fun onHandleIntent(intent: Intent?) {
        Log.d("@@@", "work DetailsService")
        intent?.let {
            val lon = it.getDoubleExtra(KEY_BUNDLE_LON,0.0)
            val lat = it.getDoubleExtra(KEY_BUNDLE_LAT,0.0)
            Log.d("@@@", "work DetailsService $lat $lon")


            val urlText =
                "https://api.weather.yandex.ru/v2/informers?lat=$lat&lon=$lon" //TODO HW выносим https://api.weather.yandex.ru/v2/informers? в Utlis.kt константы
            //val urlText = "http://212.86.114.27/v2/informers?lat=$lat&lon=$lon"
            val uri = URL(urlText)

            //val urlConnection: HttpsURLConnection = (uri.openConnection() as HttpsURLConnection).apply { для ленивых
            val urlConnection: HttpURLConnection =
                (uri.openConnection() as HttpURLConnection).apply {
                    connectTimeout = 1000 // set под капотом
                    //val r= readTimeout // get под капотом
                    readTimeout = 1000 // set под капотом
                    addRequestProperty(
                        "X-Yandex-API-Key",
                        BuildConfig.WEATHER_API_KEY
                    ) //TODO HW выносим в Utlis.kt константы
                }
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
            val weatherDTO: WeatherDTO = Gson().fromJson(buffer, WeatherDTO::class.java)


            // TODO  HW "что-то пошло не так" Snackbar?
            // TODO  HW disconnect() finally?


            val message = Intent(KEY_WAVE_SERVICE_BROADCAST)
            message.putExtra(
                KEY_BUNDLE_SERVICE_BROADCAST_WEATHER, weatherDTO
            )
            //sendBroadcast(message)
            LocalBroadcastManager.getInstance(this).sendBroadcast(message)
        }
    }
}
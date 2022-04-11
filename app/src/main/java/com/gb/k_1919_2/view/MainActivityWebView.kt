package com.gb.k_1919_2.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.gb.k_1919_2.R
import com.gb.k_1919_2.databinding.ActivityMainWebviewBinding
import com.gb.k_1919_2.lesson3.Lesson3
import com.gb.k_1919_2.lesson3.someViewGroup
import com.gb.k_1919_2.lesson4.BaseImpl
import com.gb.k_1919_2.lesson4.BossDelegate
import com.gb.k_1919_2.lesson4.Lesson4
import com.gb.k_1919_2.lesson4.Speakable
import com.gb.k_1919_2.view.weatherlist.WeatherListFragment
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.stream.Collector
import java.util.stream.Collectors
import javax.net.ssl.HttpsURLConnection

class MainActivityWebView : AppCompatActivity() {
    lateinit var binding: ActivityMainWebviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainWebviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ok.setOnClickListener {
            val urlText = binding.etTextUrl.text.toString()
            val uri = URL(urlText)
            val urlConnection: HttpsURLConnection =
                (uri.openConnection() as HttpsURLConnection).apply {
                    connectTimeout = 1000 // set под капотом
                    //val r= readTimeout // get под капотом
                    readTimeout = 1000 // set под капотом
                }

            Thread {
                val headers = urlConnection.headerFields
                val buffer = BufferedReader(InputStreamReader(urlConnection.inputStream))
                val result = getLinesAsOneBigString(buffer)
                //binding.webview.loadUrl(urlText)
                /*runOnUiThread { // 1 способ
                    binding.webview.loadData(result,"text/html; utf-8","utf-8")
                }*/
                Handler(Looper.getMainLooper()).post { // 2 способ
                    //binding.webview.loadData(result,"text/html; utf-8","utf-8")
                    binding.webview.settings.javaScriptEnabled = true
                    binding.webview.loadDataWithBaseURL(
                        null,
                        result,
                        "text/html; utf-8",
                        "utf-8",
                        null
                    )
                }

            }.start()

        }
    }

    private fun getLinesAsOneBigString(bufferedReader: BufferedReader): String {
        return bufferedReader.lines().collect(Collectors.joining("\n"));
    }


}





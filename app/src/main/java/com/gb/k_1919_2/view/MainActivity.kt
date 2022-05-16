package com.gb.k_1919_2.view

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.gb.k_1919_2.MyApp
import com.gb.k_1919_2.R
import com.gb.k_1919_2.databinding.FragmentWorkWithContentProviderBinding
import com.gb.k_1919_2.lesson10.MapsFragment
import com.gb.k_1919_2.lesson4.Lesson4
import com.gb.k_1919_2.lesson6.MainService
import com.gb.k_1919_2.lesson6.MyBroadcastReceiver
import com.gb.k_1919_2.lesson6.ThreadsFragment
import com.gb.k_1919_2.lesson9.WorkWithContentProviderFragment
import com.gb.k_1919_2.utlis.KEY_BUNDLE_ACTIVITY_MESSAGE
import com.gb.k_1919_2.utlis.KEY_SP_FILE_NAME_1_KEY_IS_RUSSIAN
import com.gb.k_1919_2.utlis.KEY_SP_FILE_NAME_1
import com.gb.k_1919_2.view.weatherlist.HistoryWeatherListFragment
import com.gb.k_1919_2.view.weatherlist.WeatherListFragment
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, WeatherListFragment.newInstance()).commit()
        }

        startService(Intent(this, MainService::class.java).apply {
            putExtra(
                KEY_BUNDLE_ACTIVITY_MESSAGE,
                "Привет сервис"
            ) // TODO HW key1 - должен быть в константах
        })


        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("mylogs_push", "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }
            val token = task.result
            Log.d("mylogs_push", "$token")
        })

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_threads -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ThreadsFragment.newInstance()).addToBackStack("")
                    .commit()
            }
            R.id.action_history -> {
                supportFragmentManager.beginTransaction()
                    .add(R.id.container, HistoryWeatherListFragment.newInstance())
                    .addToBackStack("").commit()
            }
            R.id.action_work_with_content_provider -> {
                supportFragmentManager.beginTransaction()
                    .add(R.id.container, WorkWithContentProviderFragment.newInstance())
                    .addToBackStack("").commit()
            }
            R.id.action_menu_google_maps -> {
                supportFragmentManager.beginTransaction()
                    .add(R.id.container, MapsFragment()).addToBackStack("").commit()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun Lesson4.was() {
        Log.d("@@@", "Был ${this.pr}")
    }


}








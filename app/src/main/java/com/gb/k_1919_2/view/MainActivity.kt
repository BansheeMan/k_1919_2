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

class MainActivity : AppCompatActivity() {

    companion object {
        private const val NOTIFICATION_ID_LOW = 1
        private const val NOTIFICATION_ID_HIGH = 2
        private const val CHANNEL_ID_LOW = "channel_id_1"
        private const val CHANNEL_ID_HIGH = "channel_id_2"
    }

    private fun push(){
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val notificationBuilderLow=NotificationCompat.Builder(this, CHANNEL_ID_LOW).apply {
            setSmallIcon(R.drawable.ic_map_pin)
            setContentTitle("TITLE LOW")
            setContentText("TEXT LOW")
            priority = NotificationManager.IMPORTANCE_LOW
        }

        val notificationBuilderHigh=NotificationCompat.Builder(this, CHANNEL_ID_HIGH).apply {
            setSmallIcon(R.drawable.ic_map_marker)
            setContentTitle("TITLE HIGH")
            setContentText("TEXT HIGH")
            priority = NotificationManager.IMPORTANCE_HIGH
        }




        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val channelNameHigh = "Name $CHANNEL_ID_HIGH"
            val channelDescriptionHigh = "Description $CHANNEL_ID_HIGH"
            val channelPriorityHigh = NotificationManager.IMPORTANCE_HIGH
            val channelHigh = NotificationChannel(CHANNEL_ID_HIGH,channelNameHigh,channelPriorityHigh).apply {
                description = channelDescriptionHigh
            }
            notificationManager.createNotificationChannel(channelHigh)
        }

        notificationManager.notify(NOTIFICATION_ID_HIGH,notificationBuilderHigh.build())

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val channelNameLow = "Name $CHANNEL_ID_LOW"
            val channelDescriptionLow = "Description $CHANNEL_ID_LOW"
            val channelPriorityLow = NotificationManager.IMPORTANCE_LOW
            val channelLow = NotificationChannel(CHANNEL_ID_LOW,channelNameLow,channelPriorityLow).apply {
                description = channelDescriptionLow
            }
            notificationManager.createNotificationChannel(channelLow)
        }

        notificationManager.notify(NOTIFICATION_ID_LOW,notificationBuilderLow.build())





    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, WeatherListFragment.newInstance()).commit()
        }

        startService(Intent(this,MainService::class.java).apply {
            putExtra(KEY_BUNDLE_ACTIVITY_MESSAGE,"Привет сервис") // TODO HW key1 - должен быть в константах
        })

        push()

    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_threads->{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ThreadsFragment.newInstance()).addToBackStack("").commit()
            }
            R.id.action_history->{
                supportFragmentManager.beginTransaction()
                    .add(R.id.container, HistoryWeatherListFragment.newInstance()).addToBackStack("").commit()
            }
            R.id.action_work_with_content_provider->{
                supportFragmentManager.beginTransaction()
                    .add(R.id.container, WorkWithContentProviderFragment.newInstance()).addToBackStack("").commit()
            }
            R.id.action_menu_google_maps->{
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





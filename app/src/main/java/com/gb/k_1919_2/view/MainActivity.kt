package com.gb.k_1919_2.view

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
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

        val receiver  = MyBroadcastReceiver()
        //registerReceiver(receiver, IntentFilter(KEY_WAVE))
        registerReceiver(receiver, IntentFilter("android.intent.action.AIRPLANE_MODE"))
        //LocalBroadcastManager.getInstance(this).registerReceiver(receiver, IntentFilter("myaction"))

        val sp = getSharedPreferences(KEY_SP_FILE_NAME_1, Context.MODE_PRIVATE)

        val editor =  sp.edit()
        editor.putBoolean(KEY_SP_FILE_NAME_1_KEY_IS_RUSSIAN,true)
        editor.apply()

        val defaultValueIsRussian = true
        sp.getBoolean(KEY_SP_FILE_NAME_1_KEY_IS_RUSSIAN,defaultValueIsRussian)

        MyApp.getHistoryDao().getAll()
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





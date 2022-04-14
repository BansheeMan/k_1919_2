package com.gb.k_1919_2.view

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.gb.k_1919_2.R
import com.gb.k_1919_2.lesson3.Lesson3
import com.gb.k_1919_2.lesson3.someViewGroup
import com.gb.k_1919_2.lesson4.BaseImpl
import com.gb.k_1919_2.lesson4.BossDelegate
import com.gb.k_1919_2.lesson4.Lesson4
import com.gb.k_1919_2.lesson4.Speakable
import com.gb.k_1919_2.lesson6.MainService
import com.gb.k_1919_2.lesson6.ThreadsFragment
import com.gb.k_1919_2.view.weatherlist.WeatherListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, WeatherListFragment.newInstance()).commit()
        }

        startService(Intent(this,MainService::class.java))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_threads->{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ThreadsFragment.newInstance()).commit()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun Lesson4.was() {
        Log.d("@@@", "Был ${this.pr}")
    }


}





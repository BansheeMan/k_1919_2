package com.gb.k_1919_2.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gb.k_1919_2.R
import com.gb.k_1919_2.view.main.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction().replace(R.id.container, MainFragment.newInstance()).commit()
        }
    }
}



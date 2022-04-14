package com.gb.k_1919_2.lesson6

import android.app.IntentService
import android.content.Intent
import android.util.Log

//TODO почему устаревш IntentService
class MainService(val name:String=""):IntentService(name) {
    override fun onHandleIntent(intent: Intent?) {
        Log.d("@@@","work MainService")
        
    }
}
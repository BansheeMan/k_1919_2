package com.gb.k_1919_2.lesson6

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.gb.k_1919_2.utlis.KEY_BUNDLE_SERVICE_MESSAGE

class MyBroadcastReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("@@@","MyBroadcastReceiver onReceive ${intent!!.action}")
        intent?.let {
            val extra = it.getStringExtra(KEY_BUNDLE_SERVICE_MESSAGE) // TODO HW проблема с key2
            Log.d("@@@","MyBroadcastReceiver onReceive $extra")
        }
    }
}
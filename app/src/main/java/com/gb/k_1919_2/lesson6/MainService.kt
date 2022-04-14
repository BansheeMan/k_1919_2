package com.gb.k_1919_2.lesson6

import android.app.IntentService
import android.content.Intent
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.gb.k_1919_2.utlis.KEY_BUNDLE_ACTIVITY_MESSAGE
import com.gb.k_1919_2.utlis.KEY_BUNDLE_SERVICE_MESSAGE
import com.gb.k_1919_2.utlis.KEY_WAVE
import java.lang.Thread.sleep

//TODO почему устаревш IntentService
class MainService(val name: String = "") : IntentService(name) {
    override fun onHandleIntent(intent: Intent?) {
        Log.d("@@@", "work MainService")
        intent?.let {
            val extra = it.getStringExtra(KEY_BUNDLE_ACTIVITY_MESSAGE) // TODO HW проблема с key1
            Log.d("@@@", "work MainService $extra")
            sleep(1000L)
            val message = Intent(KEY_WAVE)// TODO HW проблема с myaction
            message.putExtra(
                KEY_BUNDLE_SERVICE_MESSAGE,
                "привет активити, и тебе всего хорошего"
            )// TODO HW проблема с key2
            sendBroadcast(message)
            //LocalBroadcastManager.getInstance(this).sendBroadcast(message)
        }
    }
}
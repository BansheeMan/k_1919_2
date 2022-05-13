package com.gb.k_1919_2.lesson11

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.gb.k_1919_2.R
import com.gb.k_1919_2.view.MainActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class MyService : FirebaseMessagingService(){

    // TODO прикрепить к ДЗ Server key General->Project settings->Cloud Messaging

    override fun onMessageReceived(message: RemoteMessage) {
        if(!message.data.isNullOrEmpty()){
            val title = message.data[KEY_TITLE]
            val message = message.data[KEY_MESSAGE]
            if(!title.isNullOrEmpty()&&!message.isNullOrEmpty()){
                push(title,message)
            }
        }
    }


    companion object {
        private const val NOTIFICATION_ID_LOW = 1
        private const val CHANNEL_ID_LOW = "channel_id_1"

        private const val KEY_TITLE = "myTitle"
        private const val KEY_MESSAGE = "myMessage"
    }

    private fun push(title:String,message:String){
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


        val intent = Intent(applicationContext, MainActivity::class.java)

        val contentIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )


        val notificationBuilderHigh= NotificationCompat.Builder(this, CHANNEL_ID_LOW).apply {
            setSmallIcon(R.drawable.ic_map_marker)
            setContentTitle(title)
            setContentText(message)
            setContentIntent(contentIntent)
            priority = NotificationManager.IMPORTANCE_HIGH
        }


        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            val channelNameLow = "Name $CHANNEL_ID_LOW"
            val channelDescriptionLow = "Description $CHANNEL_ID_LOW"
            val channelPriorityLow = NotificationManager.IMPORTANCE_LOW
            val channelLow = NotificationChannel(CHANNEL_ID_LOW,channelNameLow,channelPriorityLow).apply {
                description = channelDescriptionLow
            }
            notificationManager.createNotificationChannel(channelLow)
        }

        notificationManager.notify(NOTIFICATION_ID_LOW,notificationBuilderHigh.build())





    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
    }
}
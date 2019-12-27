package com.example.myexperiments.service_testing

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import android.app.NotificationManager
import android.app.NotificationChannel
import android.os.Build
import android.graphics.Bitmap
import android.R
import android.graphics.BitmapFactory
import android.util.Log
import com.example.myexperiments.MainActivity

class MyForegroundService : Service(){
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
    val CHANNEL_ID = "channelId"
    val LOG_TAG = "TAG"
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        /*createNotificationChannel()
        val intent = Intent(this@MyForegroundService, ServiceTestingActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this@MyForegroundService, 0, intent, 0)
        val notification : Notification = NotificationCompat.Builder(this@MyForegroundService, CHANNEL_ID)
            .setContentTitle("Hello World")
            .setContentText("Description")
            .setSmallIcon(com.example.myexperiments.R.drawable.notification_icon_background)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(1, notification);*/

        if (intent?.getAction().equals(Constants.STARTFOREGROUND_ACTION)) {
            createNotificationChannel() //could be optimised  for not calling again and againg
            Log.e(LOG_TAG, "Received Start Foreground Intent ")
            val notificationIntent = Intent(this, ServiceTestingActivity::class.java)
            notificationIntent.action = Constants.MAIN_ACTION
            notificationIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            val pendingIntent = PendingIntent.getActivity(
                this, 0,
                notificationIntent, 0
            )
            val previousIntent = Intent(this, MyForegroundService::class.java)
            previousIntent.action = Constants.PREV_ACTION
            val ppreviousIntent = PendingIntent.getService(
                this, 0,
                previousIntent, 0
            )
            val playIntent = Intent(this, MyForegroundService::class.java)
            playIntent.action = Constants.PLAY_ACTION
            val pplayIntent = PendingIntent.getService(
                this, 0,
                playIntent, 0
            )
            val nextIntent = Intent(this, MyForegroundService::class.java)
            nextIntent.action = Constants.NEXT_ACTION
            val pnextIntent = PendingIntent.getService(
                this, 0,
                nextIntent, 0
            )
            val icon = BitmapFactory.decodeResource(
                resources,
                R.drawable.alert_dark_frame
            )
            val notification = NotificationCompat.Builder(this@MyForegroundService, CHANNEL_ID)
                .setContentTitle("Truiton Music Player")
                .setTicker("Truiton Music Player")
                .setContentText("My Music")
                .setSmallIcon(R.drawable.ic_menu_add)
                .setLargeIcon(
                    Bitmap.createScaledBitmap(icon, 128, 128, false)
                )
                .setContentIntent(pendingIntent)
                .setOngoing(true)
                .addAction(
                    android.R.drawable.ic_media_previous,
                    "Previous", ppreviousIntent
                )
                .addAction(
                    android.R.drawable.ic_media_play, "Play",
                    pplayIntent
                )
                .addAction(
                    android.R.drawable.ic_media_next, "Next",
                    pnextIntent
                ).build()
            startForeground(
                1, //notification Id
                notification
            )
        } else if (intent?.getAction().equals(Constants.PREV_ACTION)) {
            Log.e(LOG_TAG, "Clicked Previous")
        } else if (intent?.getAction().equals(Constants.PLAY_ACTION)) {
            Log.e(LOG_TAG, "Clicked Play")
        } else if (intent?.getAction().equals(Constants.NEXT_ACTION)) {
            Log.e(LOG_TAG, "Clicked Next")
        } else if (intent?.getAction().equals(
                Constants.STOPFOREGROUND_ACTION
            )
        ) {
            Log.e(LOG_TAG, "Received Stop Foreground Intent")
            stopForeground(true)
            stopSelf()
        }
        return Service.START_NOT_STICKY
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "Foreground Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager!!.createNotificationChannel(serviceChannel)
        }
    }
}
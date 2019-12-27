package com.example.myexperiments.service_testing

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyUnboundedService : Service(){

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val numOfExecution = intent?.getIntExtra("numOfExecution", 0)

        for (i in 1..numOfExecution as Int) {
            Thread.sleep(1000)
            Log.e("TAG", "" + i)

        }

        stopSelf()
//        return Service.START_NOT_STICKY
//        return Service.START_STICKY
        return Service.START_REDELIVER_INTENT
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("TAG", "UnBounded service destroyed")
    }
}
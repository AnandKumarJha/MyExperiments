package com.example.myexperiments.service_testing

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService : IntentService("MyService") {

    override fun onHandleIntent(intent: Intent?) {
        val numOfExecution = intent?.getIntExtra("numOfExecution", 0)

        for (i in 1..numOfExecution as Int) {
            Thread.sleep(1000)
            Log.e("TAG", "" + i)
        }
    }

}
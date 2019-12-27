package com.example.myexperiments.service_testing

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class MyBoundedService : Service(){
    var count : Int = 0
    val binder : IBinder = MyBinder()

    override fun onBind(p0: Intent?): IBinder? {
        return binder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return Service.START_NOT_STICKY
    }

    inner class MyBinder : Binder(){
        fun getBoundedService() : MyBoundedService{
            return this@MyBoundedService
        }
    }

    fun getCountValue() : Int {
        return (count++)
    }
}
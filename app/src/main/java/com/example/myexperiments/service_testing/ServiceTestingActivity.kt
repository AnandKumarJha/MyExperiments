package com.example.myexperiments.service_testing

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import kotlinx.android.synthetic.main.activity_service_testing.*
import android.content.Context
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.myexperiments.service_testing.aidl_example.MyAidlService

class ServiceTestingActivity : AppCompatActivity() {

    var boundedService: MyBoundedService? = null
    var mServiceBound = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.myexperiments.R.layout.activity_service_testing)

        btn_intent_service.setOnClickListener {
            val intent = Intent(this@ServiceTestingActivity, MyIntentService::class.java)
            intent.putExtra("numOfExecution", 10)
            startService(intent)
        }

        btn_bounded_service.setOnClickListener {
            val intent = Intent(this, MyBoundedService::class.java)
            startService(intent)
            bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
        }

        btn_get_service_data.setOnClickListener {
            if (mServiceBound) {
                Log.e("TAG", "" + boundedService?.getCountValue())
            }
        }

        btn_unbind_service.setOnClickListener {
            if (mServiceBound) {
                unbindService(serviceConnection)
                mServiceBound = false
            }
            val intent = Intent(
                this@ServiceTestingActivity,
                MyBoundedService::class.java
            )
            stopService(intent)
        }

        btn_unbounded_service.setOnClickListener {
            val intent = Intent(this@ServiceTestingActivity, MyUnboundedService::class.java)
            intent.putExtra("numOfExecution", 6)
            startService(intent)
        }

        btn_foreground_service.setOnClickListener {
            val intent = Intent(this@ServiceTestingActivity, MyForegroundService::class.java)
            intent.setAction(Constants.STARTFOREGROUND_ACTION);
            intent.putExtra("numOfExecution", 6)
            ContextCompat.startForegroundService(this, intent)
        }

        btnStopFgService.setOnClickListener {
            val stopIntent = Intent(this@ServiceTestingActivity, MyForegroundService::class.java)
            stopIntent.setAction(Constants.STOPFOREGROUND_ACTION)
            startService(stopIntent)
//            val serviceIntent = Intent(this, MyForegroundService::class.java)
//            stopService(serviceIntent)
        }

        btn_aidl.setOnClickListener {

        }


    }

    private val serviceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(p0: ComponentName?) {

        }

        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            val binder = p1 as MyBoundedService.MyBinder
            boundedService = binder.getBoundedService()
        }

    }

}

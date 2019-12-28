package com.example.myexperiments.broadcast_reciever

import android.content.BroadcastReceiver
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.IntentFilter
import com.example.myexperiments.R
import kotlinx.android.synthetic.main.activity_broadcast_testing.*
import android.content.Intent
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager


class BroadcastTestingActivity : AppCompatActivity() {

    var receiver: MyBroadcastReciever? = null
    var intentFilter: IntentFilter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_testing)

        receiver = MyBroadcastReciever()
        intentFilter = IntentFilter("com.journaldev.broadcastreceiver.SOME_ACTION")

        btn_fire_intent.setOnClickListener {
            val intent = Intent("com.journaldev.broadcastreceiver.SOME_ACTION")
            sendBroadcast(intent)
        }

        btn_local_broadcast_reciever.setOnClickListener{
            //local broadcast action fire
            LocalBroadcastManager.getInstance(this@BroadcastTestingActivity).sendBroadcast(Intent("custom_action"))
        }
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(receiver, intentFilter)

        //register local broadcast reciever
        LocalBroadcastManager.getInstance(this@BroadcastTestingActivity).registerReceiver(myBroadcastReciever, IntentFilter("custom_action"))
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)

        //register local broadcast reciever
        LocalBroadcastManager.getInstance(this@BroadcastTestingActivity).unregisterReceiver(myBroadcastReciever)
    }

    val myBroadcastReciever: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(p0: Context?, p1: Intent?) {
            Log.e("TAG", "BroadCast recieved")
        }
    }
}

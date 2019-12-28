package com.example.myexperiments.broadcast_reciever

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.IntentFilter
import com.example.myexperiments.R
import kotlinx.android.synthetic.main.activity_broadcast_testing.*
import android.content.Intent



class BroadcastTestingActivity : AppCompatActivity() {

    var receiver: MyBroadcastReciever? = null
    var intentFilter: IntentFilter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_testing)

        receiver = MyBroadcastReciever()
        intentFilter = IntentFilter("com.journaldev.broadcastreceiver.SOME_ACTION")

        btn_fire_intent.setOnClickListener{
            val intent = Intent("com.journaldev.broadcastreceiver.SOME_ACTION")
            sendBroadcast(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(receiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        registerReceiver(receiver, intentFilter)
    }
}

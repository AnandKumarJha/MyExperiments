package com.example.moduleforactiontesting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class ActionTestingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action_testing)

        Handler().postDelayed(Runnable {
            val i = Intent()
            i.setAction("com.testing.openOtherModuleActivity")
            startActivity(i)
        }, 2000)

    }
}

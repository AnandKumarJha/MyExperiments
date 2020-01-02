package com.example.mychildmodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.commonmodule.CommonTestingActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt_notification.setText("Child Activity")
    }
}

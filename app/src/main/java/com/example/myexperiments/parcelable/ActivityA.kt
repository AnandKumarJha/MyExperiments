package com.example.myexperiments.parcelable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myexperiments.R

class ActivityA : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity)
        val user = User("anand", 1, 52.5)
        val student = Student("anand", 5, 86.99)
        val intent = Intent(this@ActivityA, ActivityB::class.java)
        intent.putExtra("key", user)
        intent.putExtra("student", student)
        startActivity(intent)
    }
}

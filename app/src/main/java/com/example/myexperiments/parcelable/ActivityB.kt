package com.example.myexperiments.parcelable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myexperiments.R

class ActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val data: User = intent.getParcelableExtra<User>("key")
        Log.e("TAG", data.name + " , " + data.marks + " , " + data.rollNumer)

        val student: Student = intent.getParcelableExtra<Student>("student")
        Log.e("TAG", student.name + " , " + student.marks + " , " + student.roll_num)
    }
}

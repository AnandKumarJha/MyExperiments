package com.example.myexperiments

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log

class ChildActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_child)
    }
}
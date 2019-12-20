package com.example.myexperiments.util

import android.content.Context
import android.widget.Toast

fun Context.showToastMsg(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}

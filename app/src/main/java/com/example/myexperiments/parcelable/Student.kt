package com.example.myexperiments.parcelable

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Student(val name : String, val roll_num : Int, val marks : Double) : Parcelable
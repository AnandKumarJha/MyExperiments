package com.example.myexperiments.fragment_testing.backstack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myexperiments.R

class Fragment1 : Fragment() {

    companion object{
        val TAG = "Fragment 1"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment1, container, false)
        view.findViewById<TextView>(R.id.fragment_name).setText("Fragment 1")
        return view
    }
}
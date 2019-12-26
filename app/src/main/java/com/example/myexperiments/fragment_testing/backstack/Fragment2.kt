package com.example.myexperiments.fragment_testing.backstack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myexperiments.R

class Fragment2 : Fragment() {

    companion object{
        val TAG = "Fragment 2"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment1, container, false)
        view.findViewById<TextView>(R.id.fragment_name).setText("Fragment 2")
        return view
    }
}
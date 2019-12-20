package com.example.myexperiments

import android.app.Activity
import android.view.View
import android.widget.FrameLayout

open class BaseActivity : Activity() {
    override fun setContentView(layoutResID: Int) {
        val view: View = layoutInflater.inflate(R.layout.activity_base, null, false)
        val container: FrameLayout = view.findViewById<FrameLayout>(R.id.container)
        //attaching child layout with parent
        val view1 = layoutInflater.inflate(R.layout.activity_child, container, true)
        super.setContentView(view)
    }
}
package com.example.myexperiments.module_parent

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.commonmodule.CommonTestingActivity
import com.example.commonmodule.MyTestingKotlinClass
import com.example.myexperiments.R
import kotlinx.android.synthetic.main.activity_module_parent.*

class ModuleParentActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_parent)

        txt_notification.setText(MyTestingKotlinClass.myVar)
        //to open injected dependancy libraries activity
//        startActivity(Intent(this@ModuleParentActivity, CommonTestingActivity::class.java))

        //to open any other not dependant library
        val i = Intent()
        i.setAction("com.testing.action.non_dependant_module")
        startActivity(i)

    }
}

package com.example.myexperiments.fragment_testing.headless

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myexperiments.R

class HeadlessActivity : AppCompatActivity(),
    HeadlessFragment1.Interaction {
    override fun progress(progress : Int) {
        Log.e("Progress", ""+progress)
    }

    private lateinit var mHeadlessFragment1 : HeadlessFragment1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_headless)
        print("onCreate")

        if(savedInstanceState==null) {
            mHeadlessFragment1 = HeadlessFragment1()
            mHeadlessFragment1.startProgress()
            supportFragmentManager.beginTransaction().add(
                R.id.rl_container, mHeadlessFragment1,
                HeadlessFragment1.TAG
            ).addToBackStack(null).commit()
        }else{
            mHeadlessFragment1 = supportFragmentManager.findFragmentByTag(HeadlessFragment1.TAG) as HeadlessFragment1
        }
        mHeadlessFragment1.setProgressInterface(this)
    }

    override fun onStart() {
        print("onStart")
        super.onStart()
    }

    override fun onRestart() {
        print("onRestart")
        super.onRestart()
    }

    override fun onResume() {
        print("onResume")
        super.onResume()
    }

    override fun onPause() {
        print("onPause")
        super.onPause()
    }

    override fun onStop() {
        print("onStop")
        super.onStop()
    }

    override fun onDestroy() {
        print("onDestroy")
        Log.e("TAG", "------------------------------------------------")
        super.onDestroy()
    }

    fun print(str : String){
        Log.e("TAG", "Activity $str")
    }
}

package com.example.myexperiments.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myexperiments.R
import com.example.myexperiments.ValVsImmulatbleTesting
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class CoroutineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)

//        handleImmutableVsValTask()
        val time = measureTimeMillis {
            GlobalScope.launch(Dispatchers.Default) {

                val job1 = GlobalScope.launch(Dispatchers.IO) {
                    performRepetitiveTaskForThread("Job 1")
                    performRepetitiveTaskForThread("Job 2")
                }

//            job1.join()

//                val job2 = GlobalScope.launch(Dispatchers.IO) {
//                    performRepetitiveTaskForThread("Job 3")
//                }
            }
        }

        Log.e("TAG", "Time taken" + time)
//        runBlocking {
//        delay(1500)
//            Log.e("TAG", "1.5 s delayed")
//        }
//        Log.e("TAG", "Text without delay.")
    }


    private suspend fun performRepetitiveTaskForThread(job: String) {
        repeat(20) {
            delay(200)
            Log.e("TAG", job + " Count : " + it + " " + Thread.currentThread().name)
        }
    }

    private fun handleImmutableVsValTask() {
        val mValVsImmulatbleTesting = ValVsImmulatbleTesting()
        Log.e("TAg", "" + mValVsImmulatbleTesting.a);
        Log.e("TAg", "" + mValVsImmulatbleTesting.b);
        Log.e("TAg", "" + mValVsImmulatbleTesting.c);
        mValVsImmulatbleTesting.a = 4400
        mValVsImmulatbleTesting.b = 2000
        mValVsImmulatbleTesting.c = 2_20_2
        Log.e("TAg", "" + mValVsImmulatbleTesting.a);
        Log.e("TAg", "" + mValVsImmulatbleTesting.b);
        Log.e("TAg", "" + mValVsImmulatbleTesting.c);
    }
}

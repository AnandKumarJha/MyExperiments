package com.example.myexperiments

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class HeadlessFragment1 : Fragment() {

    private var mMyExecution: MyExecution? = null
    private var mInteraction: Interaction? = null

    interface Interaction {
        fun progress(progress: Int)
    }

    companion object {
        val TAG: String = "TAG"
    }

    fun setProgressInterface(mActivity: HeadlessActivity) {
        this.mInteraction = mActivity as Interaction
    }

    fun startProgress() {
        mMyExecution = MyExecution()
        mMyExecution?.execute()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("TAG", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("TAG", "onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.e("TAG", "onCreateView")
        return null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("TAG", "onActivityCreated")
        retainInstance = true
    }

    override fun onStart() {
        super.onStart()
        Log.e("TAG", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("TAG", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("TAG", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("TAG", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("TAG", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        mMyExecution?.cancel(true)
        Log.e("Progress TAG", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("TAG", "onDetach")
    }


    inner class MyExecution : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg p0: Void?): Void? {

            for (i in 1..30) {
                if (isCancelled)
                    break
                mInteraction?.progress(i)
                Thread.sleep(1000)
            }

            return null
        }
    }

}

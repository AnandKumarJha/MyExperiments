package com.example.myexperiments

import android.app.Activity
import android.app.Fragment
import android.os.AsyncTask
import android.os.Bundle

class HeadlessFragment : Fragment() {

    internal var mStatusCallback: TaskStatusCallback? = null
    private var mBackgroundTask: BackgroundTask? = null
    internal var isTaskExecuting = false

    interface TaskStatusCallback {
        fun onPreExecute()

        fun onProgressUpdate(progress: Int)

        fun onPostExecute()

        fun onCancelled()
    }

    /**
     * Called when a fragment is first attached to its activity.
     * onCreate(Bundle) will be called after this.
     */
    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        mStatusCallback = activity as TaskStatusCallback
    }

    /**
     * Called to do initial creation of a fragment.
     * This is called after onAttach(Activity) and before onCreateView(LayoutInflater, ViewGroup, Bundle)
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState)

        retainInstance = true
    }

    /**
     * Called when the fragment is no longer attached to its activity. This is called after onDestroy().
     */
    override fun onDetach() {
        // TODO Auto-generated method stub
        super.onDetach()
        mStatusCallback = null
    }

    private inner class BackgroundTask : AsyncTask<Void, Int, Void>() {

        override fun onPreExecute() {
            if (mStatusCallback != null)
                mStatusCallback!!.onPreExecute()
        }

        override fun doInBackground(vararg params: Void): Void? {
            var progress = 0
            while (progress < 100 && !isCancelled) {
                progress++
                publishProgress(progress)
                try {
                    Thread.sleep(500)
                } catch (e: InterruptedException) {
                    // TODO Auto-generated catch block
                    e.printStackTrace()
                }

            }
            return null
        }

        override fun onPostExecute(result: Void) {
            if (mStatusCallback != null)
                mStatusCallback!!.onPostExecute()
        }

        override fun onProgressUpdate(vararg values: Int?) {
            if (mStatusCallback != null)
                mStatusCallback!!.onProgressUpdate(values[0] as Int)
        }

        override fun onCancelled(result: Void) {
            if (mStatusCallback != null)
                mStatusCallback!!.onCancelled()
        }

    }

    fun startBackgroundTask() {
        if (!isTaskExecuting) {
            mBackgroundTask = BackgroundTask()
            mBackgroundTask?.execute()
            isTaskExecuting = true
        }
    }

    fun cancelBackgroundTask() {
        if (isTaskExecuting) {
            mBackgroundTask?.cancel(true)
            isTaskExecuting = false
        }
    }

    fun updateExecutingStatus(isExecuting: Boolean) {
        this.isTaskExecuting = isExecuting
    }

    companion object {

        val TAG_HEADLESS_FRAGMENT = "headless_fragment"
    }
}
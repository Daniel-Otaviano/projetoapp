package com.example.appfaculdade

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

open class DebugActivity : AppCompatActivity(){


    private val TAG = "LMSApp"
    private val classname: String
        get() {
            val a =  javaClass.name
            return a.substring(a.lastIndexOf("."))
    }


        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "$classname.onCreate()")
        }
        override fun onStart() {
            super.onStart()
            Log.d(TAG, "$classname.onStart()")
        }
        override fun onRestart() {
            super.onRestart()
            Log.d(TAG, "$classname.onRestart()")
        }
        override fun onResume() {
            super.onResume()
            Log.d(TAG, "$classname.onResume()")
        }
        override fun onStop() {
            super.onStop()
            Log.d(TAG, "$classname.onStop()")
        }
        override fun onDestroy() {
            super.onDestroy()
            Log.d(TAG, "$classname.onDestroy()")
        }
        override fun onPause() {
            super.onPause()
            Log.d(TAG, "$classname.onPause()")
    }
}

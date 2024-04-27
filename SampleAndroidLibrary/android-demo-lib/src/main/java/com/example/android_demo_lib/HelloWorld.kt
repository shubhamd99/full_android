package com.example.android_demo_lib

import android.util.Log

class HelloWorld {
    companion object {
        fun printLog(log: String, tag: String) {
            Log.d(log, tag)
        }
    }
}
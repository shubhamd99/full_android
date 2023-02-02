package com.example.webviewwithjsinterface.webview

import android.content.Context
import android.webkit.JavascriptInterface
import android.widget.Toast

class WebAppInterface(private val context: Context) {

    @JavascriptInterface
    fun onClicked() {
        Toast.makeText(
            context,
            "Web To Native Call!!!",
            Toast.LENGTH_SHORT
        ).show()
    }
}
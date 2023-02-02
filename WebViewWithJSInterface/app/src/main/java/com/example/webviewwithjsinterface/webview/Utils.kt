package com.example.webviewwithjsinterface.webview

import android.content.Context
import android.util.Log
import android.webkit.WebView
import android.widget.Toast

fun sendEventToWeb(
    msg: String,
    webView: WebView?,
) {
    println("WebView.....")
    println(webView)

    webView?.evaluateJavascript(
        "(function() { window.dispatchEvent( new CustomEvent(\"nativeEvent\", {bubbles: true, detail: \"$msg\"}) ); })();"
    ) { data ->
        Log.d("From Web: ", data)
    }
}
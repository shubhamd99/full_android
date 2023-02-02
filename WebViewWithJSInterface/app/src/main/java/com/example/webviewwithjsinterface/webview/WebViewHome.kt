package com.example.webviewwithjsinterface.webview

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.util.Log
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.example.webviewwithjsinterface.webview.Constants.BASE_URL
import com.google.accompanist.web.*


@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewHome() {
    val url by remember {
        mutableStateOf(BASE_URL)
    }
    val state = rememberWebViewState(url = url)
    val context = LocalContext.current
    var webViewInstance: WebView? = null

    Column {

        val loadingState = state.loadingState

        if (loadingState is LoadingState.Loading) {
            LinearProgressIndicator(
                progress = loadingState.progress,
                modifier = Modifier.fillMaxWidth()
            )
        }

        AndroidView(factory = {
            WebView(it).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                webViewClient = object : WebViewClient() {
                    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                        super.onPageStarted(view, url, favicon)
                        Log.d("Accompanist WebView", "Page started loading for $url")
                    }
                    override fun shouldOverrideUrlLoading(
                        view: WebView?,
                        request: WebResourceRequest?
                    ): Boolean {
                        return false
                    }
                }

                settings.javaScriptEnabled = true
                settings.supportZoom()
                addJavascriptInterface(WebAppInterface(context = context), "Android")


                loadUrl(url)
                webViewInstance = this
            }
        }, update = {
            webViewInstance = it
        })


        Row {
            Button(onClick = {
                sendEventToWeb(
                    msg = "Hello From Android!!",
                    webView = webViewInstance,
                )
            }) {
                Text(text = "Native To Web Call Button")
            }
        }
    }
}
package com.example.webbrowser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.webbrowser.ui.theme.MainScreen
import com.example.webbrowser.ui.theme.WebBrowserTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WebBrowserTheme {
                MainScreen()
            }
        }
    }
}

package com.example.inappupdates

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.inappupdates.ui.theme.InAppUpdatesTheme
import com.example.inappupdates.presentation.CalculatorScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InAppUpdatesTheme {
                CalculatorScreen()
            }
        }
    }
}
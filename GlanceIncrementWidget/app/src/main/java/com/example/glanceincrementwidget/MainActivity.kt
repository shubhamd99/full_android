package com.example.glanceincrementwidget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.glanceincrementwidget.ui.theme.GlanceIncrementWidgetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GlanceIncrementWidgetTheme {

            }
        }
    }
}


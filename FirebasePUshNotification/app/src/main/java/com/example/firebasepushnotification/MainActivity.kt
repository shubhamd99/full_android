package com.example.firebasepushnotification

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.firebasepushnotification.firebase.PushNotification
import com.example.firebasepushnotification.firebase.createNotificationChannel
import com.example.firebasepushnotification.ui.theme.FirebasePUshNotificationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirebasePUshNotificationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    NotificationApp()
                }
            }
        }
    }
}

@Composable
fun NotificationApp() {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        createNotificationChannel(PushNotification.CHANNEL_ID, context)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Notification App",
            style = MaterialTheme.typography.h3
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirebasePUshNotificationTheme {
        NotificationApp()
    }
}
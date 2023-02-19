package com.example.firebasepushnotification.firebase

import android.util.Log
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.firebasepushnotification.dataStore
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TechFirebaseMessageService: FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        // Log incoming message
        Log.d("CloudMessage", "From ${message.from}")
        // Log Data Payload
        if (message.data.isNotEmpty()) {
            Log.d("CloudMessage", "Message Data ${message.data}")
        }
        // Check if message contains a notification payload
        message.data.let {
            Log.d("CloudMessage", "Message Notification Body ${it["body"]}")
        }

        if (message.notification !== null) {
            Log.d("CloudMessage", "Notification ${message.notification}")
            Log.d("CloudMessage", "Notification Title ${message.notification!!.title}")
            Log.d("CloudMessage", "Notification Body ${message.notification!!.body}")

            showSimpleNotification(
                context = baseContext,
                textTitle = message.notification?.title.toString(),
                textContent = message.notification?.body.toString(),
            )
        }
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("CloudMessage", "Token $token")
        GlobalScope.launch {
            saveGTMToken(token)
        }
    }

    // Save GCM Token DataSTore Preference
    // you can used to send it on your Server.
    private suspend fun saveGTMToken(token: String) {
        val gckTokenKey = stringPreferencesKey("gcm_token")
        baseContext.dataStore.edit { pref ->
            pref[gckTokenKey] = token
        }
    }
}
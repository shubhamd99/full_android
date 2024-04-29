package com.example.inappupdates

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import com.example.inappupdates.ui.theme.InAppUpdatesTheme
import com.example.inappupdates.presentation.CalculatorScreen
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.appupdate.AppUpdateOptions
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.UpdateAvailability

class MainActivity : ComponentActivity() {

    private lateinit var appUpdateManager: AppUpdateManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize the appUpdateManager
        appUpdateManager = AppUpdateManagerFactory.create(this)
        checkForAppUpdates()

        setContent {
            InAppUpdatesTheme {
                CalculatorScreen()
            }
        }
    }

    /**
     * When you start an immediate update and the user consents to begin the update,
     * Google Play displays the update progress on top of your app's UI throughout the entire duration of the update.
     * If the user closes or terminates your app during the update,
     * the update should continue to download and install in the background without additional user confirmation.
     *
     * However, when your app returns to the foreground,
     * you should confirm that the update is not stalled in the UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS state.
     * If the update is stalled in this state, resume the update:
     */
    override fun onResume() {
        super.onResume()

        appUpdateManager
            .appUpdateInfo  // Returns an intent object that you use to check for an update.
            .addOnSuccessListener { appUpdateInfo ->
                if (appUpdateInfo.updateAvailability()
                    == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS
                ) {
                    // If an in-app update is already running, resume the update.
                    appUpdateManager.startUpdateFlowForResult(
                        appUpdateInfo,
                        activityResultLauncher,
                        AppUpdateOptions.newBuilder(AppUpdateType.IMMEDIATE).build())
                }
            }
    }

    private fun checkForAppUpdates() {
        // Checks that the platform will allow the specified type of update.
        appUpdateManager
            .appUpdateInfo  // Returns an intent object that you use to check for an update.
            .addOnSuccessListener { appUpdateInfo ->
                // If the update is downloaded but not installed,
                // notify the user to complete the update.
                // if (appUpdateInfo.installStatus() == InstallStatus.DOWNLOADED) {
                    // appUpdateManager.completeUpdate()
                // }

                if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                    // This example applies an immediate update. To apply a flexible update
                    // instead, pass in AppUpdateType.FLEXIBLE
                    && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)
                ) {
                    // Request the update.
                    appUpdateManager.startUpdateFlowForResult(
                        // Pass the intent that is returned by 'getAppUpdateInfo()'.
                        appUpdateInfo,
                        // an activity result launcher registered via registerForActivityResult
                        activityResultLauncher,
                        // Or pass 'AppUpdateType.FLEXIBLE' to newBuilder() for
                        // flexible updates.
                        AppUpdateOptions.newBuilder(AppUpdateType.IMMEDIATE).build()
                    )
                }


            }
            .addOnFailureListener { error ->
                Log.e("Failed to fetch app update info", error.message.toString())
            }
    }

    private val activityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartIntentSenderForResult()
    ) { result ->
        when (val resultCode = result.resultCode) {
            Activity.RESULT_OK -> {
                Log.v("MyActivity", "Update flow completed!")
            }
            Activity.RESULT_CANCELED -> {
                Log.v("MyActivity", "User cancelled Update flow!")
            }
            else -> {
                Log.v("MyActivity", "Update flow failed with resultCode:$resultCode")
            }
        }
    }
}
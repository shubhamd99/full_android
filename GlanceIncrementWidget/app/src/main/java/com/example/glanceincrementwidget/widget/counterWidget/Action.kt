package com.example.glanceincrementwidget.widget.counterWidget

import android.content.Context
import androidx.glance.GlanceId
import androidx.glance.action.ActionParameters
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.state.updateAppWidgetState

object IncrementActionCallback: ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters
    ) {
        updateAppWidgetState(context, glanceId) { prefs -> // shared preferences
            val currentCount = prefs[Constants.countKey]
            if (currentCount != null) {
                prefs[Constants.countKey] = currentCount + 1
            } else {
                prefs[Constants.countKey] = 1
            }
        }
       Widget.update(context, glanceId) // to tell the widget to update
    }
}
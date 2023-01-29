package com.example.noteapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp // This gives Hilt access to entire application
class NoteApplication : Application() {

}
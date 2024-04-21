package com.example.parallelapicalls.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.parallelapicalls.repository.LivingThingsRepository

class LivingThingsViewModel: ViewModel() {

    private val repository: LivingThingsRepository = LivingThingsRepository()

    fun doSomeApiCalls() {
        repository.returnSomeItems{human, animal ->
            Log.e("humans", human.toString())
            Log.e("animals", animal.toString())
        }
    }
}
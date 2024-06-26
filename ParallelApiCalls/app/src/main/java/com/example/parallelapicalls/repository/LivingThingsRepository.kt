package com.example.parallelapicalls.repository

import android.util.Log
import com.example.parallelapicalls.model.Animal
import com.example.parallelapicalls.model.Human
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LivingThingsRepository {

    fun returnSomeItems(result: (human: List<Human>, animal: List<Animal>) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {

            val humansResponse = async {
                Log.e("calling", "humans")
                getHumans()
            }

            val animalsResponse = async {
                Log.e("calling", "animals")
                getAnimals()
            }

            val humans = humansResponse.await()
            val animals = animalsResponse.await()

            result(humans, animals)
        }
    }

    private suspend fun getHumans(): List<Human> {
        val list = mutableListOf<Human>()

        for (i in 1..10) {
            list.add(
                Human(
                    "Putin",
                    "Russian"
                )
            )
        }

        delay(1000)
        Log.e("sending ", "get humans")

        return list
    }

    private suspend fun getAnimals(): List<Animal> {
        val list = mutableListOf<Animal>()

        for (i in 1..10) {
            list.add(
                Animal(
                    "Bear",
                    "Vodka"
                )
            )
        }

        delay(3000)
        Log.e("sending ", "get animals")

        return list
    }
}
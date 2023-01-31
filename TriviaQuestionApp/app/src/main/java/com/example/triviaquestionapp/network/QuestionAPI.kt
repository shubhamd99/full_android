package com.example.triviaquestionapp.network

import com.example.triviaquestionapp.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionAPI {

    @GET("world.json")
    suspend fun getAllQuestions(): Question

}
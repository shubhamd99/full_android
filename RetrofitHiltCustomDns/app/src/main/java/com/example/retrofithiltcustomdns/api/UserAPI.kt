package com.example.retrofithiltcustomdns.api

import com.example.retrofithiltcustomdns.models.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface UserAPI {

    @GET(value = "/users")
    @Headers("Cache-Control: public, max-age=0") // Static
    suspend fun getUsers(): Response<List<User>>
}
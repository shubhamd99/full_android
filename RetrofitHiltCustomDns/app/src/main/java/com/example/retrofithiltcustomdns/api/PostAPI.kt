package com.example.retrofithiltcustomdns.api

import com.example.retrofithiltcustomdns.models.PostListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface PostAPI {

    @GET(value = "/posts")
    suspend fun getPosts(
        @Header("sample-header") header: String // Dynamic
    ): Response<List<PostListItem>>


}
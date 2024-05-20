package com.example.retrofithiltcustomdns.repository

import com.example.retrofithiltcustomdns.api.PostAPI
import com.example.retrofithiltcustomdns.models.PostListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class PostRepository @Inject constructor(private val postAPI: PostAPI) {
    private val _posts = MutableStateFlow<List<PostListItem>>(emptyList())
    val posts: StateFlow<List<PostListItem>>
        get() = _posts

    suspend fun getPosts(header: String) {
        val response = postAPI.getPosts(header)

        if (response.isSuccessful && response.body() != null) {
            // Handle successful response
            _posts.emit(response.body()!!)
        }
    }
}
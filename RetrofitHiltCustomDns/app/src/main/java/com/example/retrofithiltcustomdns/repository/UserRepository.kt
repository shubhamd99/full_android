package com.example.retrofithiltcustomdns.repository

import com.example.retrofithiltcustomdns.api.UserAPI
import com.example.retrofithiltcustomdns.models.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class UserRepository @Inject constructor(private val userAPI: UserAPI) {

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>>
        get() = _users

    suspend fun getUsers() {
        val response = userAPI.getUsers()
        if (response.isSuccessful && response.body() != null) {
            // Handle successful response
            _users.emit(response.body()!!)
        }
    }
}
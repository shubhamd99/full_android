package com.example.retrofithiltcustomdns.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofithiltcustomdns.models.PostListItem
import com.example.retrofithiltcustomdns.models.User
import com.example.retrofithiltcustomdns.repository.PostRepository
import com.example.retrofithiltcustomdns.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val postRepository: PostRepository
): ViewModel() {
    val users: StateFlow<List<User>>
        get() = userRepository.users

    val posts: StateFlow<List<PostListItem>>
        get() = postRepository.posts

    init {
        viewModelScope.launch {
            userRepository.getUsers()
            postRepository.getPosts("sample-header")
        }
    }

}
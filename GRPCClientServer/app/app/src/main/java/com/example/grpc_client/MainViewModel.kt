package com.example.grpc_client

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grpc_client.network.sendMessage
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    fun onIpChange(value: String) {
        _ip.value = value
    }

    fun onPortChange(value: String) {
        _port.value = value
    }

    fun onMessageChange(value: String) {
        _message.value = value
    }

    fun onSendClick() {
        viewModelScope.launch {
            val r = sendMessage(
                _message.value,
                _ip.value,
                _port.value
            )
            if(r is String){
                _result.value = r
            }
        }
    }

    private val _ip = mutableStateOf("")
    val ip: State<String> = _ip

    private val _port = mutableStateOf("")
    val port: State<String> = _port

    private val _message = mutableStateOf("")
    val message:State<String> = _message

    private val _result = mutableStateOf("")
    val result:State<String> = _result
}
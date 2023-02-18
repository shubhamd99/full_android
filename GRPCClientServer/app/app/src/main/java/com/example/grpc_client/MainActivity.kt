package com.example.grpc_client

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.grpc_client.ui.theme.Grpc_clientTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val vm: MainViewModel by viewModels()
        super.onCreate(savedInstanceState)
        setContent {
            Grpc_clientTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text("GRPC")
                                }
                            )
                        }
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(24.dp)
                        ){
                            OutlinedTextField(
                                value = vm.ip.value,
                                onValueChange = {
                                    vm.onIpChange(it)
                                },
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = {
                                    Text("IP address")
                                },
                                label = {
                                    Text("Server")
                                }
                            )
                            OutlinedTextField(
                                value = vm.port.value,
                                onValueChange = {
                                    vm.onPortChange(it)
                                },
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = {
                                    Text("Port")
                                },
                                label = {
                                    Text("Port")
                                }
                            )
                            OutlinedTextField(
                                value = vm.message.value,
                                onValueChange = {
                                    vm.onMessageChange(it)
                                },
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = {
                                    Text("Message")
                                },
                                label = {
                                    Text("Message")
                                }
                            )
                            Button(
                                onClick = {
                                    vm.onSendClick()
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Send")
                            }
                            Text("Result: ${vm.result.value}")
                        }
                    }
                }
            }
        }
    }
}
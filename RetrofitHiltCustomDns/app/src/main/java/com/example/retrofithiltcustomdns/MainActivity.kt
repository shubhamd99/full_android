package com.example.retrofithiltcustomdns

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.retrofithiltcustomdns.ui.theme.RetrofitHiltCustomDnsTheme
import com.example.retrofithiltcustomdns.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RetrofitHiltCustomDnsTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MyScreen()
                }
            }
        }
    }
}

@Composable
fun MyScreen() {
    val mainViewModel: MainViewModel = viewModel()
    val users = mainViewModel.users.collectAsState()
    val posts = mainViewModel.posts.collectAsState()

    Log.e("MainActivity onCreate: users", users.value.size.toString())
    Log.e("MainActivity onCreate: posts", posts.value.size.toString())
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RetrofitHiltCustomDnsTheme {
        MyScreen()
    }
}
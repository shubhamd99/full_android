package com.example.retrofithiltcustomdns

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.retrofithiltcustomdns.api.PostAPI
import com.example.retrofithiltcustomdns.api.UserAPI
import com.example.retrofithiltcustomdns.ui.theme.RetrofitHiltCustomDnsTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var postAPI: PostAPI

    @Inject
    lateinit var userAPI: UserAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // TODO: Remove Debug Code
        GlobalScope.launch {
            val postRes = postAPI.getPosts("sample-header")
            val userRes = userAPI.getUsers()

            Log.d("MainActivity postRes:", "onCreate: ${postRes.body().toString()}")
            Log.d("MainActivity userRes:", "onCreate: ${userRes.body().toString()}")
        }

        setContent {
            RetrofitHiltCustomDnsTheme {

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RetrofitHiltCustomDnsTheme {

    }
}
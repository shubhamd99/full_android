package com.example.parallelapicalls

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parallelapicalls.ui.theme.ParallelApiCallsTheme
import com.example.parallelapicalls.viewmodel.LivingThingsViewModel

class MainActivity : ComponentActivity() {

    private val viewModel : LivingThingsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ParallelApiCallsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Shubham D.", viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    livingThingsViewModel: LivingThingsViewModel = viewModel(),
    modifier: Modifier = Modifier,
) {
    LaunchedEffect(Unit) {
        // Code to be run when the composable is mounted
        livingThingsViewModel.doSomeApiCalls()
    }

    Text(
        text = "Hello from: $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ParallelApiCallsTheme {
        Greeting("Android")
    }
}
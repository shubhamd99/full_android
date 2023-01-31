package com.example.triviaquestionapp.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.triviaquestionapp.component.Questions

@Composable
fun TriviaHome() {
    val viewModel = viewModel<QuestionsViewModel>()
    val data = viewModel.data.collectAsState().value

    Questions(
        data = data,
        viewModel = viewModel
    )
}
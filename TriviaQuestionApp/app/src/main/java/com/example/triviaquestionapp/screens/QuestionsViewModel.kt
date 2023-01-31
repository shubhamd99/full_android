package com.example.triviaquestionapp.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.triviaquestionapp.data.DataOrException
import com.example.triviaquestionapp.model.QuestionItem
import com.example.triviaquestionapp.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(
    private val repository: QuestionRepository
): ViewModel() {
    private val _data: MutableStateFlow<DataOrException<ArrayList<QuestionItem>, Boolean, Exception>> = MutableStateFlow(DataOrException(null, true, Exception("")))
    val data = _data.asStateFlow()


    init {
        getAllQuestions()
    }

    private fun getAllQuestions() {
        viewModelScope.launch {
            _data.value.loading = true
            _data.value = repository.getAllQuestions()
            if (_data.value.data.toString().isNotEmpty()) {
                _data.value.loading = false
            }
        }
    }

    fun getTotalQuestionCount(): Int {
        return data.value.data?.toMutableList()?.size!!
    }

}
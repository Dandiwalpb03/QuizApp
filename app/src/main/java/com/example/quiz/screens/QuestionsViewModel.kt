package com.example.quiz.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiz.data.DataOrException
import com.example.quiz.model.QuestionItem
import com.example.quiz.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// When a class is annotated with "@Inject", Hilt can automatically provide instances of
// that class( QuestionViewModel class )  to other classes that depend on it.
@HiltViewModel // Hilt can automatically provide instances of a ViewModel to other classes that depend on it.
class QuestionsViewModel @Inject constructor(
    private val repository: QuestionRepository
): ViewModel() {
    val data: MutableState<DataOrException<ArrayList<QuestionItem>, Boolean, Exception>>
    = mutableStateOf(DataOrException(null, true, Exception("")))

    init {
        getAllQuestions()
    }
    private fun getAllQuestions(){
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getAllQuestions1()

        }
    }
}
package com.example.quiz.repository

import com.example.quiz.data.DataOrException
import com.example.quiz.model.QuestionItem
import com.example.quiz.networks.QuestionAPI
import javax.inject.Inject

// When a class is annotated with "@Inject", Hilt can automatically provide instances of
// that class(QuestionRepository class )  to other classes that depend on it.
/**In the code you provided, the constructor of the "QuestionRepository" class is annotated with "@Inject".
This means that Hilt can automatically provide an instance of the "QuestionRepository" class to other classes that depend on it.*/
class QuestionRepository @Inject constructor(
    private val api: QuestionAPI
    //The constructor takes a single parameter of type "QuestionAPI", which is also annotated with "@Inject".
    //This means that Hilt can automatically provide an instance of the "QuestionAPI" interface
    // to the constructor of the "QuestionRepository" class
) {
    // In this way you can get data but we can't know some additional information about is data loading
    // or there any error occurred while loading and which exception rises.
    //    private val listOfQuestions = ArrayList<QuestionItem>(emptyList())
    // So we Introduced new Data Class called DataOrException which will fill the gap between
    // our need and what we are getting from the above method of getting data.
    private val dataOrException = DataOrException<ArrayList<QuestionItem>,
            Boolean,
            Exception> ()

    suspend fun getAllQuestions1(): DataOrException<ArrayList<QuestionItem>, Boolean, Exception> {
        // DataOrException<ArrayList<QuestionItem>, Boolean, Exception> this the return type fo this function.
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestion() // getAllQuestions will fetch the data and
            // assign to data (to ArrayList<QuestionItem>)
            if(dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false
        }
        catch (exception: Exception){
            dataOrException.e = exception
        }
        return dataOrException
    }
}
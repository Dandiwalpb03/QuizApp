package com.example.quiz.data

/**
 * This class will add additional info to the Question we are getting from the API.
 * @param T Generic data type to store the questions.
 * @param Boolean This boolean will tell us if data is loading or not.
 * @param E This will tell us if any exception arises.
 */
data class DataOrException<T, Boolean, E: Exception>(
    var data: T? = null,
    var loading: Boolean? = null,
    var e: E? = null

)

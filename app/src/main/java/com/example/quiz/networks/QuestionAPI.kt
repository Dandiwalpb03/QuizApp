package com.example.quiz.networks

import com.example.quiz.model.Question
import retrofit2.http.GET
import javax.inject.Singleton


@Singleton // using singleton because for app there should be only single sucrose of truth.
interface QuestionAPI {
    /**
     * this fun is asynchronous, suspendable, presumable because of coroutine
     * And this function will fetch the data.*/
    @GET("movies.json") // retrofit will fetch data.
    suspend fun getAllQuestion(): Question
}
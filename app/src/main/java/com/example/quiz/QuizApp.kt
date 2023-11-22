package com.example.quiz

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * This class is Controls UI. */
@HiltAndroidApp // It is used to mark the Application class as the entry point for Hilt dependency injection.
class QuizApp: Application() {
    //The Application class is the base class for maintaining global application state,
    // and it is extended here to create a new class called "QuizApp".
    // By extending the Application class, the "QuizApp" class can access the application context
    // and perform tasks such as initializing libraries, setting up global variables,
    // and managing the application lifecycle.
}
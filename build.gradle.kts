// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    // adding ksp(kotlin symbol processing) instead of kapt
    id("com.google.devtools.ksp") version "1.6.20-1.0.4" apply true
    // Hilt Dagger
    id ("com.google.dagger.hilt.android") version "2.48" apply false
    //Dokka
    id("org.jetbrains.dokka") version "1.9.0" apply true
}

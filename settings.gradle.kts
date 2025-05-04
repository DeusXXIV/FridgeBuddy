// settings.gradle.kts
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        id("com.android.application") version "8.1.0"
        kotlin("android")            version "1.8.21"
        kotlin("kapt")               version "1.8.21"
    }
}
rootProject.name = "FridgeBuddy"
include(":app")

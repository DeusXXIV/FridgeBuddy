// Root build.gradle.kts
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.0")               // AGP plugin
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.21") // Kotlin plugin
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

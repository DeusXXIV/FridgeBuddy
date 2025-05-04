// File: FridgeViewModelFactory.kt
// Location: app/src/main/java/com/example/fridgebuddy/ui

package com.example.fridgebuddy.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fridgebuddy.data.AppDatabase
import com.example.fridgebuddy.data.FridgeRepository

class FridgeViewModelFactory(private val repository: FridgeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FridgeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FridgeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


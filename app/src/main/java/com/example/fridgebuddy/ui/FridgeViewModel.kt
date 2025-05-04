package com.example.fridgebuddy.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.fridgebuddy.data.FridgeItem
import com.example.fridgebuddy.data.FridgeRepository
import kotlinx.coroutines.launch

class FridgeViewModel(
    private val repository: FridgeRepository
) : ViewModel() {

    /** Live list of items the UI observes */
    val items = repository.getAllItems().asLiveData()

    fun add(item: FridgeItem) = viewModelScope.launch {
        repository.addOrUpdate(item)
    }

    fun delete(item: FridgeItem) = viewModelScope.launch {
        repository.delete(item)
    }
}

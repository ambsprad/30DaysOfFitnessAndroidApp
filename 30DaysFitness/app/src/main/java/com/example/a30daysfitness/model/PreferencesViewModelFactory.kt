package com.example.a30daysfitness.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a30daysfitness.data.PreferencesRepository

class PreferencesViewModelFactory(
    private val repository: PreferencesRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PreferencesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PreferencesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
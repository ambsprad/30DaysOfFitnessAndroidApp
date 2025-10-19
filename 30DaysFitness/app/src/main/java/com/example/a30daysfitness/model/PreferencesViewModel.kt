package com.example.a30daysfitness.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a30daysfitness.data.PreferencesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class PreferencesViewModel(private val repository: PreferencesRepository) : ViewModel() {

    private val _warmUpDuration = MutableStateFlow(10) // default 10 min
    val warmUpDuration: StateFlow<Int> = _warmUpDuration

    private val _coolDownDuration = MutableStateFlow(15) // default 15 min
    val coolDownDuration: StateFlow<Int> = _coolDownDuration

    init {
        viewModelScope.launch {
            repository.warmUpDuration.collect { _warmUpDuration.value = it }
        }
        viewModelScope.launch {
            repository.coolDownDuration.collect { _coolDownDuration.value = it }
        }
    }
    fun setWarmUpDuration(duration: Int) {
        viewModelScope.launch {
            repository.setWarmUpDuration(duration)
            _warmUpDuration.value = duration
        }
    }

    fun setCoolDownDuration(duration: Int) {
        viewModelScope.launch {
            repository.setCoolDownDuration(duration)
            _coolDownDuration.value = duration
        }
    }
}


//class PreferencesViewModel : ViewModel() {
//
//    // Warm-up duration options
//    val warmUpOptions = listOf(5, 7, 10)
//    private val _warmUpDuration = MutableStateFlow(10) // default 10 minutes
//    val warmUpDuration: StateFlow<Int> = _warmUpDuration.asStateFlow()
//
//    // Cool-down duration options
//    val coolDownOptions = listOf(5, 10, 15)
//    private val _coolDownDuration = MutableStateFlow(15) // default 15 minutes
//    val coolDownDuration: StateFlow<Int> = _coolDownDuration.asStateFlow()
//
//    fun setWarmUpDuration(minutes: Int) {
//        _warmUpDuration.value = minutes
//    }
//
//    fun setCoolDownDuration(minutes: Int) {
//        _coolDownDuration.value = minutes
//    }
//}
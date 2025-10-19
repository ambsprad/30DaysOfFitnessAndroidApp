package com.example.a30daysfitness.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a30daysfitness.data.PreferencesRepository
import com.example.a30daysfitness.data.WorkoutDataProvider
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// View Model for Workout App
class WorkoutViewModel(private val repository: PreferencesRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(
        WorkoutUiState(
            workoutList = WorkoutDataProvider.getWorkoutData(),
            currentWorkout = WorkoutDataProvider.getWorkoutData().getOrElse(0) {
                WorkoutDataProvider.defaultWorkout
            }
        )
    )
    val uiState: StateFlow<WorkoutUiState> = _uiState

    private val _navigateToDetail = MutableSharedFlow<Unit>()
    val navigateToDetail = _navigateToDetail.asSharedFlow()

    // Collect from repository
    val warmUpDuration = repository.warmUpDuration.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        10
    )

    val coolDownDuration = repository.coolDownDuration.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        15
    )

    fun updateCurrentWorkout(selectedWorkout: Workout) {
        _uiState.update {
            it.copy(currentWorkout = selectedWorkout)
        }
    }
    fun navigateToListPage() {
        _uiState.update {
            it.copy(isShowingListPage = true)
        }
    }
    fun navigateToDetailPage() {
        _uiState.update {
            it.copy(isShowingListPage = false)
        }
    }
    fun onWorkoutClicked(selectedWorkout: Workout) {
        updateCurrentWorkout(selectedWorkout)
        viewModelScope.launch {
            _navigateToDetail.emit(Unit)
        }
    }
}

data class WorkoutUiState(
    val workoutList: List<Workout> = WorkoutDataProvider.getWorkoutData(),
    val currentWorkout: Workout = WorkoutDataProvider.defaultWorkout,
    val isShowingListPage: Boolean = true
)
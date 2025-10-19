package com.example.a30daysfitness.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Workout(
    val id: Int,
    @StringRes val dayId: Int,
    @StringRes val workoutTypeId: Int,
    @DrawableRes val iconId: Int,
    @StringRes val workoutPlan: Int
)

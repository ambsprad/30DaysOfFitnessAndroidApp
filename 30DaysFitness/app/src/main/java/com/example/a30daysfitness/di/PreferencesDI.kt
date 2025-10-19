package com.example.a30daysfitness.di

import android.content.Context
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore by preferencesDataStore(name = "user_preferences")

object PreferencesKeys {
    val WARM_UP_DURATION = intPreferencesKey("warm_up_duration")
    val COOL_DOWN_DURATION = intPreferencesKey("cool_down_duration")
}


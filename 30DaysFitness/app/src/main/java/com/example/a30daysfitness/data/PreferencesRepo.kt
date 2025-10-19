package com.example.a30daysfitness.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import com.example.a30daysfitness.di.PreferencesKeys
import com.example.a30daysfitness.di.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PreferencesRepository(private val context: Context) {

    private val dataStore = context.dataStore

    val warmUpDuration: Flow<Int> = dataStore.data
        .map { preferences ->
            preferences[PreferencesKeys.WARM_UP_DURATION] ?: 10 // Default to 10 minutes
        }

    val coolDownDuration: Flow<Int> = dataStore.data
        .map { preferences ->
            preferences[PreferencesKeys.COOL_DOWN_DURATION] ?: 15 // Default to 15 minutes
        }

    suspend fun setWarmUpDuration(duration: Int) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.WARM_UP_DURATION] = duration
        }
    }

    suspend fun setCoolDownDuration(duration: Int) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.COOL_DOWN_DURATION] = duration
        }
    }
}



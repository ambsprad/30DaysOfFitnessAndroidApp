package com.example.a30daysfitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import com.example.a30daysfitness.ui.WorkoutApp
import com.example.a30daysfitness.ui.theme.My30DaysFitnessTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            My30DaysFitnessTheme {
                WorkoutApp()
            }
        }
    }
}


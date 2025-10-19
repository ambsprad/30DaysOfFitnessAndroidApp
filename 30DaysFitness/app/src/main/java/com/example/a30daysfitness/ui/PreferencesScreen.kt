package com.example.a30daysfitness.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.a30daysfitness.R
import com.example.a30daysfitness.model.PreferencesViewModel


@Composable
fun PreferenceScreen(viewModel: PreferencesViewModel) {
    val warmUpDuration = viewModel.warmUpDuration.collectAsState()
    val coolDownDuration = viewModel.coolDownDuration.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(text = "Set Warm-Up Duration", style = MaterialTheme.typography.titleMedium)

        listOf(5, 7, 10).forEach { minutes ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { viewModel.setWarmUpDuration(minutes) }
                    .padding(vertical = 4.dp)
            ) {
                RadioButton(
                    selected = (minutes == warmUpDuration.value),
                    onClick = { viewModel.setWarmUpDuration(minutes) }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "$minutes minutes")
            }
        }

        Divider(modifier = Modifier.padding(vertical = 16.dp))

        Text(text = "Set Cool-Down Duration", style = MaterialTheme.typography.titleMedium)

        listOf(5, 10, 15).forEach { minutes ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { viewModel.setCoolDownDuration(minutes) }
                    .padding(vertical = 4.dp)
            ) {
                RadioButton(
                    selected = (minutes == coolDownDuration.value),
                    onClick = { viewModel.setCoolDownDuration(minutes) }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "$minutes minutes")
            }
        }
    }
}

//@Composable
//fun PreferenceScreen(viewModel: PreferencesViewModel) {
//
//    val warmUp by viewModel.warmUpDuration.collectAsState()
//    val coolDown by viewModel.coolDownDuration.collectAsState()
//
//    val warmUpOptions = viewModel.warmUpOptions
//    val coolDownOptions = viewModel.coolDownOptions
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.spacedBy(24.dp)
//    ) {
//
//        Text(text = "Set Warm-Up Duration", style = MaterialTheme.typography.titleMedium)
//
//        // Warm-Up Radio Buttons
//        warmUpOptions.forEach { minutes ->
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .clickable { viewModel.setWarmUpDuration(minutes) }
//                    .padding(vertical = 4.dp)
//            ) {
//                RadioButton(
//                    selected = (minutes == warmUp),
//                    onClick = { viewModel.setWarmUpDuration(minutes) }
//                )
//                Spacer(modifier = Modifier.width(8.dp))
//                Text(text = "$minutes minutes")
//            }
//        }
//
//        Divider(modifier = Modifier.padding(vertical = 16.dp))
//
//        Text(text = "Set Cool-Down Duration", style = MaterialTheme.typography.titleMedium)
//
//        // Cool-Down Radio Buttons
//        coolDownOptions.forEach { minutes ->
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .clickable { viewModel.setCoolDownDuration(minutes) }
//                    .padding(vertical = 4.dp)
//            ) {
//                RadioButton(
//                    selected = (minutes == coolDown),
//                    onClick = { viewModel.setCoolDownDuration(minutes) }
//                )
//                Spacer(modifier = Modifier.width(8.dp))
//                Text(text = "$minutes minutes")
//            }
//        }
//    }
//}



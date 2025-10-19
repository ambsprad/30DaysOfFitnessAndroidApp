package com.example.a30daysfitness.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.a30daysfitness.R
import com.example.a30daysfitness.model.Workout
import com.example.a30daysfitness.model.WorkoutViewModel
import com.example.a30daysfitness.ui.theme.My30DaysFitnessTheme

@Composable
fun WorkoutDetail(
    viewModel: WorkoutViewModel,
    selectedWorkout: Workout,
    onBackPressed: () -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
){
    BackHandler {
        onBackPressed()
    }
    val scrollState = rememberScrollState()
    val layoutDirection = LocalLayoutDirection.current


    val warmUp by viewModel.warmUpDuration.collectAsState()
    val coolDown by viewModel.coolDownDuration.collectAsState()

    Box(
        modifier = modifier
            .verticalScroll(state = scrollState)
    ) {
        Column(
            modifier = Modifier
                .padding(
                    bottom = contentPadding.calculateTopPadding(),
                    start = contentPadding.calculateStartPadding(layoutDirection),
                    end = contentPadding.calculateEndPadding(layoutDirection)
                )
        ) {
            Image(
                painter = painterResource(selectedWorkout.iconId),
                contentDescription = null,
                alignment = Alignment.TopCenter,
                contentScale = ContentScale.Crop, //ContentScale.FillWidth
                modifier = Modifier
                    .fillMaxWidth()
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                ) {
                    Column {
                        Text(
                            text = stringResource(selectedWorkout.dayId)+" - " + stringResource(selectedWorkout.workoutTypeId),
                            style = MaterialTheme.typography.displayMedium,
                            modifier = Modifier
                                .padding(horizontal = dimensionResource(R.dimen.padding_small))
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // Show user’s preferences
                        Text(
                            text = "Warm-up Duration: $warmUp minutes",
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                        Text(
                            text = "Cool-down Duration: $coolDown minutes",
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = stringResource(selectedWorkout.workoutPlan),
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(
                                vertical = dimensionResource((R.dimen.padding_detail_content_vertical)),
                                horizontal = dimensionResource(R.dimen.padding_detail_content_horizontal)
                            )
                        )
                    }

                }
        }
    }
}
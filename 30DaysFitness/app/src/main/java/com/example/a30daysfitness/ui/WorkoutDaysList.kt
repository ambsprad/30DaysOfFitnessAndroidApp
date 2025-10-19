package com.example.a30daysfitness.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.a30daysfitness.R
import com.example.a30daysfitness.model.Workout

@Composable
fun WorkoutList(
    workouts: List<Workout>,
    onClick: (Workout) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
){
    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        modifier = modifier.padding(top = dimensionResource(R.dimen.padding_small)),
    ) {
        items(workouts, key = { workout -> workout.id  }) { workout ->
            WorkoutListItem(
                workout = workout,
                onItemClick = onClick
            )

        }
    }
}

@Composable
fun WorkoutListItem(
    workout: Workout,
    onItemClick: (Workout) -> Unit,
    modifier: Modifier = Modifier
){
    Card(
        elevation = CardDefaults.cardElevation(),
        modifier = modifier,
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        onClick = { onItemClick(workout) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(dimensionResource(R.dimen.card_image_height))
        ){
            WorkoutListImageItem(
                workout = workout,
                modifier = Modifier.size(dimensionResource(R.dimen.card_image_height))
            )
            Column(
                modifier = Modifier
                    .padding(
                        vertical = dimensionResource(R.dimen.padding_small),
                        horizontal = dimensionResource(R.dimen.padding_medium)
                    )
                    .weight(1f)
            ) {
                Text(
                    text = stringResource(workout.dayId),
                    style = MaterialTheme.typography.displaySmall,
                    modifier = Modifier.padding(bottom = dimensionResource(R.dimen.card_text_vertical_space))
                )
                Text(
                    text = stringResource(workout.workoutTypeId),
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}

@Composable
fun WorkoutListImageItem(workout: Workout, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(workout.iconId),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.FillWidth
        )
    }
}


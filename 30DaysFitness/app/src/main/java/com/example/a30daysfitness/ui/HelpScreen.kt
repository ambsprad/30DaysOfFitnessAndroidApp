package com.example.a30daysfitness.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysfitness.R
import com.example.a30daysfitness.ui.theme.My30DaysFitnessTheme

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier
){
    val scrollState = rememberScrollState()
    Column(
        Modifier
            .fillMaxWidth()
            .verticalScroll(state = scrollState)
    ){
        Text(
            text = stringResource(R.string.help_screen_text),
            style = MaterialTheme.typography.headlineSmall,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.pref_label),
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = stringResource(R.string.pref_help_screen_text),
            style = MaterialTheme.typography.headlineSmall
        )
    }




}

@Preview
@Composable
fun HelpScreenPreview() {
    My30DaysFitnessTheme {
        Surface {
            AboutScreen()
        }
    }
}
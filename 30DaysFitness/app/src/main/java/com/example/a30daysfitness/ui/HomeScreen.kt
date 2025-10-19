package com.example.a30daysfitness.ui

import android.content.Context
import androidx.activity.compose.BackHandler
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.a30daysfitness.R
import com.example.a30daysfitness.data.PreferencesRepository
import com.example.a30daysfitness.data.WorkoutDataProvider
import com.example.a30daysfitness.model.PreferencesViewModel
import com.example.a30daysfitness.model.PreferencesViewModelFactory
import com.example.a30daysfitness.model.WorkoutViewModel
import com.example.a30daysfitness.model.WorkoutViewModelFactory
import com.example.a30daysfitness.ui.theme.My30DaysFitnessTheme


enum class WorkoutScreen(@StringRes val title: Int) {
    Home(title = R.string.app_name),
    FullWorkout(title = R.string.list_fragment_label),
    About(title = R.string.about_screen),
    Preferences(title = R.string.preferences_screen)
}
@Composable
fun WorkoutApp(
    context: Context = LocalContext.current,
    navController: NavHostController = rememberNavController(),
){
    val repository = remember { PreferencesRepository(context) }

    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = WorkoutScreen.valueOf(
        backStackEntry?.destination?.route ?: WorkoutScreen.Home.name
    )

    // use a factory so the ViewModel is not recreated
    val preferencesViewModel: PreferencesViewModel = viewModel(
        factory = PreferencesViewModelFactory(repository)
    )
    val workoutViewModel: WorkoutViewModel = viewModel(
        factory = WorkoutViewModelFactory(repository)
    )

    val uiState by workoutViewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            WorkoutAppBar(
                currentScreen = currentScreen,
                canNavigateBack = currentScreen != WorkoutScreen.Home, //prevent back button on home screen
                navigateUp = {navController.navigateUp()},
                navController = navController
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = WorkoutScreen.Home.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            composable(route = WorkoutScreen.Home.name) {
                // Disable system back press on Home
                BackHandler(enabled = true) {
                    // Do nothing — prevents navigating back
                }
                WorkoutList(
                    workouts = uiState.workoutList,
                    onClick = { workout ->
                        workoutViewModel.onWorkoutClicked(workout)
                   },
                    modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium)),
                    contentPadding = innerPadding
               )

                LaunchedEffect(Unit) {
                    workoutViewModel.navigateToDetail.collect {
                        navController.navigate(WorkoutScreen.FullWorkout.name)
                    }
                }
            }
            composable(route = WorkoutScreen.FullWorkout.name) {
                WorkoutDetail(
                    selectedWorkout = uiState.currentWorkout,
                    contentPadding = innerPadding,
                    viewModel = workoutViewModel,
                    onBackPressed = {
                        workoutViewModel.navigateToListPage()
                    }
                )
            }
            composable(route = WorkoutScreen.About.name) {
                AboutScreen()
            }
            composable(route = WorkoutScreen.Preferences.name){
                PreferenceScreen(viewModel = preferencesViewModel)
            }
        }

    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkoutAppBar(
    currentScreen: WorkoutScreen,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit,
    navController: NavController
){
    TopAppBar(
        title = {
            Text(
                text = stringResource(currentScreen.title),
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = if (canNavigateBack) {
            {
                IconButton(onClick = navigateUp) {
                    Icon (
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        } else{ {Box{}} },
        actions = {
            IconButton(onClick = {
                navController.navigate(WorkoutScreen.Home.name)
            }) {
                Icon(Icons.Filled.Home, contentDescription = "Home Screen")
            }
            IconButton(onClick = {
                navController.navigate(WorkoutScreen.Preferences.name)
            }) {
                Icon(Icons.Filled.Settings, contentDescription = "Preferences")
            }
            IconButton(onClick = {
                navController.navigate((WorkoutScreen.About.name))
            }) {
                Icon(Icons.Filled.Info, contentDescription = "Help")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        ),
        modifier = modifier,
    )
}

@Preview
@Composable
fun WorkoutAppPreview() {
    My30DaysFitnessTheme {
        Surface {
            WorkoutList(
                workouts = WorkoutDataProvider.getWorkoutData(),
                onClick = {},
            )
        }
    }
}

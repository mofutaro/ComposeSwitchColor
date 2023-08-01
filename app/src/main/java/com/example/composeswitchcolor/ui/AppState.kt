package com.example.composeswitchcolor.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.composeswitchcolor.model.data.ColorConfig
import com.example.composeswitchcolor.model.data.DarkThemeConfig
import com.example.composeswitchcolor.navigation.MainRoute
import com.example.composeswitchcolor.navigation.TopLevelDestination
import com.example.composeswitchcolor.ui.theme.colors.ColorPreset
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController(),
    viewModel: AppViewModel = viewModel()
): AppState {
    return remember {
        AppState(navController, viewModel)
    }
}


@Stable
class AppState(
    val navController: NavHostController,
    private val viewModel: AppViewModel
) {

    val uiState: AppViewModel.UiState
        @Composable get() = viewModel.uiState.collectAsState().value

    val colorConfig: ColorConfig
        @Composable get() = uiState.userData.colorConfig

    val colorPreset: ColorPreset
        @Composable get() {
            return when(uiState.userData.colorConfig) {
                ColorConfig.BLUE -> ColorPreset.Blue
                ColorConfig.GREEN -> ColorPreset.Green
                ColorConfig.LIGHT_BLUE -> ColorPreset.LightBlue
                ColorConfig.ORANGE -> ColorPreset.Orange
                ColorConfig.PINK -> ColorPreset.Pink
                ColorConfig.RED -> ColorPreset.Red
                ColorConfig.YELLOW -> ColorPreset.Yellow
            }
        }

    val shouldUseDarkTheme: Boolean
        @Composable get() = when (uiState.userData.darkThemeConfig) {
            DarkThemeConfig.FOLLOW_SYSTEM -> isSystemInDarkTheme()
            DarkThemeConfig.LIGHT -> false
            DarkThemeConfig.DARK -> true
        }

    val shouldShowBottomBar: Boolean
        @Composable get() = currentTopLevelDestination != null

    val shouldShowOnBoarding: Boolean
        @Composable get() = uiState.userData.shouldShowOnBoarding

    fun updateColorConfig(colorConfig: ColorConfig) {
        viewModel.updateColorConfig(colorConfig)
    }

    fun updateDarkThemeConfig(darkThemeConfig: DarkThemeConfig) {
        viewModel.updateDarkThemeConfig(darkThemeConfig)
    }

    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()
    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            MainRoute.TOP -> TopLevelDestination.TOP
            MainRoute.SETTINGS -> TopLevelDestination.SETTINGS
            else -> null
        }

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }

        navController.navigate(topLevelDestination.route, topLevelNavOptions)

    }

    private fun NavBackStackEntry.lifecycleIsResumed() =
        this.lifecycle.currentState == Lifecycle.State.RESUMED

    fun onBackPressed(from: NavBackStackEntry) {
        if (from.lifecycleIsResumed()) {
            navController.navigateUp()
        }
    }

    fun finishOnBoarding() {
        viewModel.finishOnBoarding()
    }

}
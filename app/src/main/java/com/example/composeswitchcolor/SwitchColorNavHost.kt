package com.example.composeswitchcolor

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composeswitchcolor.navigation.MainRoute
import com.example.composeswitchcolor.ui.AppState
import com.example.composeswitchcolor.ui.settings.SettingScreen
import com.example.composeswitchcolor.ui.top.TopScreen

@Composable
fun SwitchColorNavHost(
    appState: AppState,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = appState.navController,
        startDestination = MainRoute.TOP,
        modifier = modifier
    ) {
        composable(MainRoute.TOP) {
            TopScreen(modifier = Modifier.fillMaxSize())
        }
        composable(MainRoute.SETTINGS) {
            SettingScreen(
                appState = appState,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
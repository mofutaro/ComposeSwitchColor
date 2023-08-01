package com.example.composeswitchcolor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.composeswitchcolor.ui.AppState
import com.example.composeswitchcolor.ui.onboarding.OnBoardingScreen

@Composable
fun SwitchColorApp(
    appState: AppState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.inverseOnSurface
            )
    ) {
        if (appState.shouldShowOnBoarding) {
            OnBoardingScreen(finish = appState::finishOnBoarding, modifier = Modifier.fillMaxSize())
        } else {
            SwitchColorNavHost(
                appState = appState,
                modifier = Modifier.weight(1f)
            )
            if (appState.shouldShowBottomBar) {
                SwitchColorBottomBar(
                    destinations = appState.topLevelDestinations,
                    onNavigateToDestination = appState::navigateToTopLevelDestination,
                    currentDestination = appState.currentDestination
                )
            }
        }

    }
}
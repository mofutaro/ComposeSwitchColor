package com.example.composeswitchcolor.ui

import androidx.lifecycle.ViewModel
import com.example.composeswitchcolor.model.UserData
import com.example.composeswitchcolor.model.data.ColorConfig
import com.example.composeswitchcolor.model.data.DarkThemeConfig
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppViewModel: ViewModel() {
    data class UiState(
        val userData: UserData
    )

    private val defaultUserData = UserData(
        colorConfig = ColorConfig.RED,
        darkThemeConfig = DarkThemeConfig.LIGHT,
        shouldShowOnBoarding = true
    )

    private val initialState = UiState(
        userData = defaultUserData
    )

    private val _uiState = MutableStateFlow(initialState)

    val uiState get() = _uiState.asStateFlow()

    fun updateColorConfig(colorConfig: ColorConfig) {
        _uiState.update { state ->
            state.copy(
                state.userData.copy(
                    colorConfig = colorConfig
                )
            )
        }
    }

    fun updateDarkThemeConfig(darkThemeConfig: DarkThemeConfig) {
        _uiState.update { state ->
            state.copy(
                state.userData.copy(
                    darkThemeConfig = darkThemeConfig
                )
            )
        }
    }

    fun finishOnBoarding() {
        _uiState.update { state ->
            state.copy(
                state.userData.copy(
                    shouldShowOnBoarding = false
                )
            )
        }
    }
}
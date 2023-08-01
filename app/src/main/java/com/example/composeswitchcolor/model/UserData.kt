package com.example.composeswitchcolor.model

import com.example.composeswitchcolor.model.data.ColorConfig
import com.example.composeswitchcolor.model.data.DarkThemeConfig

data class UserData(
    val colorConfig: ColorConfig,
    val darkThemeConfig: DarkThemeConfig,
    val shouldShowOnBoarding: Boolean,
)
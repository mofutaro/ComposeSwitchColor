package com.example.composeswitchcolor.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class TopLevelDestination(
    val route: String,
    val icon: ImageVector,
    val iconText: String,
    val titleText: String,
) {
    TOP(
        route = MainRoute.TOP,
        icon = Icons.Rounded.Check,
        iconText = "トップ",
        titleText = "トップ"
    ),
    SETTINGS(
        route = MainRoute.SETTINGS,
        icon = Icons.Rounded.Settings,
        iconText = "設定",
        titleText = "設定"
    )
}
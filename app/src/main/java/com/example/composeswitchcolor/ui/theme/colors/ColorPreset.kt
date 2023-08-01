package com.example.composeswitchcolor.ui.theme.colors

import androidx.compose.material3.ColorScheme

enum class ColorPreset(
    val lightColorScheme: ColorScheme,
    val darkColorScheme: ColorScheme
) {
    Red(
        com.example.composeswitchcolor.ui.theme.colors.red.LightColorScheme,
        com.example.composeswitchcolor.ui.theme.colors.red.DarkColorScheme
    ),
    Orange(
        com.example.composeswitchcolor.ui.theme.colors.orange.LightColorScheme,
        com.example.composeswitchcolor.ui.theme.colors.orange.DarkColorScheme
    ),
    Yellow(
        com.example.composeswitchcolor.ui.theme.colors.yellow.LightColorScheme,
        com.example.composeswitchcolor.ui.theme.colors.yellow.DarkColorScheme
    ),
    Green(
        com.example.composeswitchcolor.ui.theme.colors.green.LightColorScheme,
        com.example.composeswitchcolor.ui.theme.colors.green.DarkColorScheme
    ),
    LightBlue(
        com.example.composeswitchcolor.ui.theme.colors.lightblue.LightColorScheme,
        com.example.composeswitchcolor.ui.theme.colors.lightblue.DarkColorScheme
    ),
    Blue(
        com.example.composeswitchcolor.ui.theme.colors.blue.LightColorScheme,
        com.example.composeswitchcolor.ui.theme.colors.blue.DarkColorScheme
    ),
    Pink(
        com.example.composeswitchcolor.ui.theme.colors.pink.LightColorScheme,
        com.example.composeswitchcolor.ui.theme.colors.pink.DarkColorScheme
    )
}
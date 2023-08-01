package com.example.composeswitchcolor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.composeswitchcolor.ui.rememberAppState
import com.example.composeswitchcolor.ui.theme.ComposeSwitchColorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val appState = rememberAppState()
            ComposeSwitchColorTheme(
                preset = appState.colorPreset,
                darkTheme = appState.shouldUseDarkTheme
            ) {
                SwitchColorApp(appState = appState, modifier = Modifier.fillMaxSize())
            }
        }
    }
}

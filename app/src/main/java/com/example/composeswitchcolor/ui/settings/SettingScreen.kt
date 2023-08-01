package com.example.composeswitchcolor.ui.settings

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.composeswitchcolor.model.data.ColorConfig
import com.example.composeswitchcolor.model.data.DarkThemeConfig
import com.example.composeswitchcolor.ui.AppState

@Composable
fun SettingScreen(
    appState: AppState,
    modifier: Modifier = Modifier
) {
    val colorOptions = remember { ColorConfig.values() }
    val selectedColor = appState.colorConfig
    Box(modifier = modifier.background(
        MaterialTheme.colorScheme.surface
    )) {
        LazyColumn {
            item {
                ListItem(
                    headlineContent = {
                        Text("ダークモード")
                    },
                    trailingContent = {
                        Switch(
                            checked = appState.shouldUseDarkTheme,
                            onCheckedChange = {
                                Log.d("Switch", "shouldUseDarkTheme: ${it}")
                                if (it) {
                                    appState.updateDarkThemeConfig(DarkThemeConfig.DARK)
                                } else {
                                    appState.updateDarkThemeConfig(DarkThemeConfig.LIGHT)
                                }
                            }
                        )
                    }
                )
            }
            item {
                val isSystemDark = isSystemInDarkTheme()
                ListItem(
                    headlineContent = {
                        Text("端末の設定を使う")
                    },
                    supportingContent = {
                        Text("端末のディスプレイと明るさの設定で選択した[ライト]または[ダーク]を適用するには、ダークモードを設定します。")
                    },
                    trailingContent = {
                        Switch(
                            checked = appState.uiState.userData.darkThemeConfig == DarkThemeConfig.FOLLOW_SYSTEM,
                            onCheckedChange = {
                                Log.d("Switch", "FollowSystem ${it}")
                                when {
                                    it -> appState.updateDarkThemeConfig(DarkThemeConfig.FOLLOW_SYSTEM)
                                    isSystemDark -> appState.updateDarkThemeConfig(DarkThemeConfig.DARK)
                                    else -> appState.updateDarkThemeConfig(DarkThemeConfig.LIGHT)
                                }
                            }
                        )
                    }

                )
            }
            /*item {
                ListItem(
                    headlineContent = {
                        Text("ダイナミックカラー")
                    },
                    supportingContent = {
                        Text("ホーム画面の壁紙の色を使用します。")
                    },
                    trailingContent = {
                        Switch(checked = useDynamicColor, onCheckedChange = { appState.updateDynamicColorPreference(useDynamicColor = it) })
                    }

                )
            }*/
            item {
                ListItem(
                    headlineContent = {
                        Text("テーマ", style = MaterialTheme.typography.titleLarge)
                    }
                )
            }
            items(colorOptions) {
                ListItem(
                    headlineContent = {
                        Text(it.label)
                    },
                    modifier
                        .selectable(
                            selected = selectedColor == it,
                            onClick = { appState.updateColorConfig(it) }
                        ),
                    trailingContent = {
                        RadioButton(
                            selected = selectedColor == it,
                            onClick = { appState.updateColorConfig(it)
                            }
                        )
                    }
                )
            }
        }
    }
}
package com.charan.themeify.feature_settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.charan.themeify.common.TopBar

@Composable
fun SettingsScreen() {
    Scaffold(
        topBar = {
            TopBar(title = "Settings")
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(
                top = paddingValues.calculateTopPadding() + 20.dp,
            )
        ) {
            SettingsItem(
                onClick = {},
                title = "Theme",
                subTitle = "Customize app appearance"
            )
            SettingsItem(
                onClick = {},
                title = "Currency",
                subTitle = "Change your preferred currency"
            )
            SettingsItem(
                onClick = {},
                title = "About",
                subTitle = "Learn more about the app"
            )
        }
    }
}

@Preview
@Composable
private fun SettingsScreenPreview() {
    SettingsScreen()
}
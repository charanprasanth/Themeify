package com.charan.themeify.feature_settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.charan.themeify.common.TopBar

@Composable
fun SettingsScreen() {
    Scaffold(
        topBar = {
            TopBar(title = "Settings")
        },
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {  }
    }
}
package com.charan.themeify.feature_dynamic_theme.data

import androidx.compose.ui.graphics.Color

data class ThemeConfig(
    val isDarkTheme: Boolean = false,
    val primaryColor: Color = Color(0xFF6750A4),
    val backgroundColor: Color = Color(0xFFFFFBFE),
    val textColor: Color = Color(0xFF000000)
)

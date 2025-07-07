package com.charan.themeify.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.charan.themeify.feature_dynamic_theme.data.ThemeConfig

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

@Composable
fun ThemeifyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

@Composable
fun DynamicTheme(
    themeConfig: ThemeConfig,
    content: @Composable () -> Unit
) {
    val colorScheme = if (themeConfig.isDarkTheme) {
        darkColorScheme(
            primary = themeConfig.primaryColor,
            onBackground = themeConfig.textColor,
            onSurface = themeConfig.textColor,
            background = themeConfig.backgroundColor,
            secondaryContainer = themeConfig.primaryColor.copy(alpha = 0.1f),
            surfaceContainer = themeConfig.primaryColor.copy(alpha = 0.05f),
        )
    } else {
        lightColorScheme(
            primary = themeConfig.primaryColor,
            onBackground = themeConfig.textColor,
            onSurface = themeConfig.textColor,
            background = themeConfig.backgroundColor,
            secondaryContainer = themeConfig.primaryColor.copy(alpha = 0.1f),
            surfaceContainer = themeConfig.primaryColor.copy(alpha = 0.05f),
        )
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = CustomTypography(themeConfig.textColor),
        content = content
    )
}

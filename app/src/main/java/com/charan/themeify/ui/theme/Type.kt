package com.charan.themeify.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

fun CustomTypography(textColor: Color) = Typography(
    displayLarge = TextStyle(color = textColor, fontSize = 57.sp),
    displayMedium = TextStyle(color = textColor, fontSize = 45.sp),
    displaySmall = TextStyle(color = textColor, fontSize = 36.sp),
    headlineLarge = TextStyle(color = textColor, fontSize = 32.sp),
    headlineMedium = TextStyle(color = textColor, fontSize = 28.sp),
    headlineSmall = TextStyle(color = textColor, fontSize = 24.sp),
    titleLarge = TextStyle(color = textColor, fontSize = 22.sp),
    titleMedium = TextStyle(color = textColor, fontSize = 16.sp),
    titleSmall = TextStyle(color = textColor, fontSize = 14.sp),
    bodyLarge = TextStyle(color = textColor, fontSize = 16.sp),
    bodyMedium = TextStyle(color = textColor, fontSize = 14.sp),
    bodySmall = TextStyle(color = textColor, fontSize = 12.sp),
    labelLarge = TextStyle(color = textColor, fontSize = 14.sp),
    labelMedium = TextStyle(color = textColor, fontSize = 12.sp),
    labelSmall = TextStyle(color = textColor, fontSize = 11.sp),
)

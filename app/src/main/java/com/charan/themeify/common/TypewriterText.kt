package com.charan.themeify.common

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextStyle
import kotlinx.coroutines.delay

@Composable
fun TypewriterText(
    text: String,
    delayPerChar: Long = 50L,
    style: TextStyle = MaterialTheme.typography.bodyMedium
) {
    var visibleText by remember { mutableStateOf("") }

    LaunchedEffect(text) {
        visibleText = ""
        for (i in 1..text.length) {
            visibleText = text.substring(0, i)
            delay(delayPerChar)
        }
    }

    Text(
        text = visibleText,
        style = style,
    )
}

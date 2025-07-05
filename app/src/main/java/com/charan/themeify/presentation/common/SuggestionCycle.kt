package com.charan.themeify.presentation.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SuggestionChip
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SuggestionCycle(
    suggestions: List<String>,
    onSuggestionSelected: (String) -> Unit = {}
) {
    Box(modifier = Modifier.padding(vertical = 8.dp)) {
        Column {
            suggestions.forEach {
                if (it.isNotEmpty()) {
                    SuggestionChip(
                        onClick = {
                            onSuggestionSelected(it)
                        },
                        label = {
                            TypewriterText(text = it)
                        }
                    )
                }
            }
        }
    }
}

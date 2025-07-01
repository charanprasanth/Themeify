package com.charan.themeify.presentation.feature_dynamic_theme

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DynamicThemeDialog(
    viewModel: DynamicThemeViewModel = viewModel(),
    showDialog: Boolean,
    onDismiss: () -> Unit,
) {
    var prompt by remember { mutableStateOf(TextFieldValue("")) }
    if (showDialog) {
        AnimatedVisibility(
            visible = true,
            modifier = Modifier.fillMaxSize(),
            enter = fadeIn(animationSpec = tween(durationMillis = 1500)),
            exit = fadeOut(animationSpec = tween(durationMillis = 1500))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.background)
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Text(
                        "Change App Settings",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                    Text(
                        "What would you like to do?",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    TextField(
                        value = prompt,
                        onValueChange = { prompt = it },
                        shape = RoundedCornerShape(16.dp),
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            errorIndicatorColor = Color.Transparent,
                        ),
                        singleLine = false,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            onClick = {
                                viewModel.processUserInput(prompt.text)
                            },
                            enabled = prompt.text.isNotEmpty(),
                            colors = ButtonColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                contentColor = MaterialTheme.colorScheme.onPrimary,
                                disabledContainerColor = MaterialTheme.colorScheme.primary.copy(
                                    alpha = 0.5f
                                ),
                                disabledContentColor = MaterialTheme.colorScheme.onPrimary.copy(
                                    alpha = 0.5f
                                ),
                            )
                        ) {
                            Text(
                                "Customise",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                        Text(
                            "Close",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.clickable(
                                onClick = onDismiss
                            )
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun ppp() {
    DynamicThemeDialog(showDialog = true, onDismiss = {})
}
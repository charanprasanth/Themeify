package com.charan.themeify.feature_home

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SpendingOverTime() {
    Column(
        modifier = Modifier.padding(horizontal = 15.dp)
    ) {
        Text(
            text = "Spending Over Time",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 3.dp)
        )
        Text(
            text = "$1250",
            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Medium),
            modifier = Modifier.padding(bottom = 3.dp)
        )
        Text(
            text = "Last 30 days",
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Light),
            modifier = Modifier.padding(bottom = 15.dp)
        )
        Box(
            modifier = Modifier
                .padding(bottom = 15.dp)
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(
                    1.dp,
                    MaterialTheme.colorScheme.primary,
                    RoundedCornerShape(10.dp)
                )
        ) {}
    }
}
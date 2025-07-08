package com.charan.themeify.feature_budget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.charan.themeify.common.TopBar

@Composable
fun BudgetScreen() {
    Scaffold(
        topBar = {
            TopBar(title = "Budget")
        },
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding)
        ) {
            item {
                Text(
                    text = "Monthly Budgets",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier.padding(15.dp)
                )
            }
            items(5) {
                BudgetItem()
            }
        }
    }
}

@Preview
@Composable
private fun BudgetScreenPreview() {
    BudgetScreen()
}
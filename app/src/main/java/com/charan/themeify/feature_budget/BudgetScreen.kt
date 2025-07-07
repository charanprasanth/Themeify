package com.charan.themeify.feature_budget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.charan.themeify.common.TopBar

@Composable
fun BudgetScreen() {
    Scaffold(
        topBar = {
            TopBar(title = "Budget")
        },
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {  }
    }
}
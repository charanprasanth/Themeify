package com.charan.themeify.presentation.feature_home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel()
) {
    Scaffold { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .background(color = Color.Red)
            ) { }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .background(color = Color.Green)
            ) { }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}
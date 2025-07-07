package com.charan.themeify.feature_category

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.charan.themeify.common.TopBar

@Composable
fun CategoriesScreen() {
    Scaffold(
        topBar = {
            TopBar(
                title = "Categories",
                includeBackButton = true,
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                containerColor = MaterialTheme.colorScheme.primary,
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Favorite"
                )
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding).padding(top = 10.dp)
        ) {
            items(100) {
                CategoryItem()
            }
        }
    }
}

@Preview
@Composable
private fun ScreenPreview() {
    CategoriesScreen()
}

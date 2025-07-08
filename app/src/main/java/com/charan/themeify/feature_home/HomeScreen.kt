package com.charan.themeify.feature_home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopBar(title = "Overview")
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
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    start = 15.dp,
                    end = 15.dp,
                    bottom = 0.dp
                )
        ) {
            item {
                Row(
                    modifier = Modifier.padding(top = 15.dp, bottom = 35.dp)
                ) {
                    HomeScreenOverViewContainer(
                        modifier = Modifier.weight(1f),
                        title = "Total Spent",
                        value = "$1,250"
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    HomeScreenOverViewContainer(
                        modifier = Modifier.weight(1f),
                        title = "Budget",
                        value = "$2,250"
                    )
                }
                SpendingOverTime()
            }
            item {
                Text(
                    text = "Recent Transactions",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier.padding(
                        bottom = 25.dp,
                        top = 20.dp,
                        start = 15.dp,
                        end = 15.dp
                    )
                )
            }
            items(100) {
                RecentTransactionsItem()
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}
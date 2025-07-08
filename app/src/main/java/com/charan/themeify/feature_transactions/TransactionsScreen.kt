package com.charan.themeify.feature_transactions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.charan.themeify.common.TopBar

@Composable
fun TransactionsScreen() {
    Scaffold(
        topBar = {
            TopBar(title = "Transactions")
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
                Filters()
            }
            item {
                TransactionDateItem("Today")
            }
            items(3) {
                TransactionItem()
            }
            item {
                TransactionDateItem("Today")
            }
            items(2) {
                TransactionItem()
            }
            item {
                TransactionDateItem("Today")
            }
            items(4) {
                TransactionItem()
            }
        }
    }
}

@Composable
fun Filters() {
    Row(
        modifier = Modifier.padding(
            top = 15.dp,
            start = 15.dp,
            end = 15.dp
        )
    ) {
        FilterChip(
            selected = true,
            onClick = { /*TODO*/ },
            label = {
                Text("All")
            },
            modifier = Modifier.padding(end = 10.dp)
        )
        FilterChip(
            selected = true,
            onClick = {3 },
            label = {
                Text("This Month")
            }
        )
    }
}

@Composable
fun TransactionDateItem(date: String) {
    Text(
        text = date,
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

@Composable
fun TransactionItem() {
    Row(
        modifier = Modifier.padding(bottom = 15.dp, start = 15.dp, end = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colorScheme.surfaceContainer),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = Icons.Outlined.Home,
                contentDescription = "Home",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(30.dp),
            )
        }
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .padding(start = 10.dp),
        ) {
            Text(
                text = "Housing",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Medium
                ),
            )
            Text(
                text = "Groceries",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Light
                ),
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "-$12",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Light
            ),
        )
    }
}

@Preview
@Composable
private fun TransactionsScreenPreview() {
    TransactionsScreen()
}
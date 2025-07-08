package com.charan.themeify.feature_transactions

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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

@Preview
@Composable
private fun TransactionDateItemPreview() {
    TransactionDateItem("12/12/12")
}
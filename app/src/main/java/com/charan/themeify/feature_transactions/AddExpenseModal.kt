package com.charan.themeify.feature_transactions

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.charan.themeify.common.TopBar

@Composable
fun AddExpenseModal() {
    Scaffold(
        topBar = {
            TopBar(
                title = "New Expense",
                includeBackButton = true
            )
        },
        modifier = Modifier.fillMaxSize(),
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            AppTextField(
                value = "",
                onValueChange = {},
                label = "Expense Name",
                modifier = Modifier.padding(15.dp)
            )
            AppTextField(
                value = "",
                onValueChange = {},
                label = "Date",
                modifier = Modifier.padding(15.dp)
            )
            AppTextField(
                value = "",
                onValueChange = {},
                label = "Category",
                modifier = Modifier.padding(15.dp)
            )
            AppTextField(
                value = "",
                onValueChange = {},
                label = "Note",
                singleLine = false,
                height = 120,
                modifier = Modifier.padding(15.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {},
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()
                    .height(55.dp),
            ) {
                Text(
                    "Save",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}


@Preview
@Composable
private fun AddExpenseModalPreview() {
    AddExpenseModal()
}
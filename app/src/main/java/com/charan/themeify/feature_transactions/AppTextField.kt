package com.charan.themeify.feature_transactions

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    singleLine: Boolean = true,
    height: Int = 55,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(label, color = Color.Gray) },
        singleLine = singleLine,
        modifier = modifier
            .fillMaxWidth()
            .height(height.dp),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        shape = RoundedCornerShape(12.dp)
    )
}

@Preview
@Composable
private fun AppTextFieldPreview() {
    AppTextField(
        value = "",
        onValueChange = {},
        label = "Note",
        singleLine = false,
        height = 120,
        modifier = Modifier.padding(15.dp)
    )
}

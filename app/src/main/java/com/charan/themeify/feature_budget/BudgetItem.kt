package com.charan.themeify.feature_budget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BudgetItem() {
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
                text = "Remaining $1250",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Light
                ),
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Score(55)
        Text(
            text = "55",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Normal
            ),
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}

@Composable
fun Score(score: Int) {
    Row(
        modifier = Modifier
            .width(100.dp)
            .height(7.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(score / 100f)
                .background(MaterialTheme.colorScheme.primary)
        ) {}
    }
}

@Preview
@Composable
private fun BudgetItemPreview() {
    BudgetItem()
}
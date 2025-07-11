package com.charan.themeify.feature_home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.ehsannarmani.compose_charts.LineChart
import ir.ehsannarmani.compose_charts.models.AnimationMode
import ir.ehsannarmani.compose_charts.models.DividerProperties
import ir.ehsannarmani.compose_charts.models.DrawStyle
import ir.ehsannarmani.compose_charts.models.GridProperties
import ir.ehsannarmani.compose_charts.models.HorizontalIndicatorProperties
import ir.ehsannarmani.compose_charts.models.LabelHelperProperties
import ir.ehsannarmani.compose_charts.models.LabelProperties
import ir.ehsannarmani.compose_charts.models.Line

@Composable
fun SpendingOverTime() {
    Column(
        modifier = Modifier.padding(horizontal = 15.dp)
    ) {
        Text(
            text = "Spending Over Time",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 3.dp)
        )
        Text(
            text = "$1250",
            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Medium),
            modifier = Modifier.padding(bottom = 3.dp)
        )
        Text(
            text = "Last 30 days",
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Light),
            modifier = Modifier.padding(bottom = 15.dp)
        )
        Box(
            modifier = Modifier
                .padding(bottom = 15.dp)
                .fillMaxWidth()
                .height(200.dp)
        ) {
            val primaryColor = MaterialTheme.colorScheme.primary
            LineChart(
                gridProperties = GridProperties(false),
                labelProperties = LabelProperties(
                    true,
                    labels = arrayListOf("", "Feb", "Apr", "Jun", "Aug", "Oct", "Dec"),
                    rotation = LabelProperties.Rotation(
                        mode = LabelProperties.Rotation.Mode.Force,
                        degree = 0f
                    )
                ),
                indicatorProperties = HorizontalIndicatorProperties(false),
                labelHelperProperties = LabelHelperProperties(false),
                dividerProperties = DividerProperties(false),
                modifier = Modifier.fillMaxSize().padding(top = 10.dp),
                data = remember {
                    listOf(
                        Line(
                            label = "",
                            values = listOf(28.0, 41.0, 5.0, 10.0, 35.0, 28.0, 41.0, 5.0, 10.0, 35.0, 24.0, 9.0),
                            color = SolidColor(primaryColor),
                            firstGradientFillColor = primaryColor.copy(alpha = .25f),
                            secondGradientFillColor = Color.Transparent,
                            gradientAnimationDelay = 1000,
                            drawStyle = DrawStyle.Stroke(width = 2.dp),
                        )
                    )
                },
                animationMode = AnimationMode.Together(
                    delayBuilder = {
                        it * 500L
                    }
                ),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SpendingOverTimePreview() {
    SpendingOverTime()
}
package com.charan.themeify

import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.charan.themeify.feature_dashboard.DashboardScreen
import com.charan.themeify.feature_dynamic_theme.presentation.DynamicThemeDialog
import com.charan.themeify.feature_dynamic_theme.presentation.DynamicThemeViewModel
import com.charan.themeify.feature_home.HomeScreen
import com.charan.themeify.services.ShakeDetector
import com.charan.themeify.ui.theme.DynamicTheme
import com.charan.themeify.ui.theme.ThemeifyTheme

class MainActivity : ComponentActivity() {

    private val viewModel: DynamicThemeViewModel by viewModels()
    private lateinit var sensorManager: SensorManager
    private lateinit var shakeDetector: ShakeDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val themeConfig = viewModel.themeConfig

            DynamicTheme(themeConfig = themeConfig) {
                var showDialog by remember { mutableStateOf(false) }

                LaunchedEffect(Unit) {
                    sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
                    val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

                    shakeDetector = ShakeDetector {
                        showDialog = true
                    }

                    sensorManager.registerListener(
                        shakeDetector,
                        accelerometer,
                        SensorManager.SENSOR_DELAY_UI
                    )
                }

                DisposableEffect(Unit) {
                    onDispose {
                        sensorManager.unregisterListener(shakeDetector)
                    }
                }

                DashboardScreen()

                if (showDialog) {
                    DynamicThemeDialog(
                        showDialog = showDialog,
                        onDismiss = {
                            showDialog = false
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ThemeifyTheme {
        HomeScreen()
    }
}
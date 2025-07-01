package com.charan.themeify.services

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import kotlin.math.abs
import kotlin.math.sqrt

class ShakeDetector(private val onShake: () -> Unit) : SensorEventListener {

    private var lastShakeTime = 0L
    private var shakeCount = 0
    private var lastDirectionX = 0
    private val shakeThreshold = 13.5f
    private val shakeWindowMs = 800L
    private val minShakeCount = 3

    override fun onSensorChanged(event: SensorEvent?) {
        if (event == null || event.sensor.type != Sensor.TYPE_ACCELEROMETER) return

        val x = event.values[0]
        val y = event.values[1]
        val z = event.values[2]

        val acceleration = sqrt(x * x + y * y + z * z) - SensorManager.GRAVITY_EARTH
        val now = System.currentTimeMillis()

        if (acceleration > shakeThreshold) {
            val currentDirectionX = if (x > 0) 1 else -1

            if (currentDirectionX != lastDirectionX) {
                shakeCount++
                lastDirectionX = currentDirectionX
            }

            if (now - lastShakeTime > shakeWindowMs) {
                shakeCount = 1 // start a new window
            }

            lastShakeTime = now

            if (shakeCount >= minShakeCount) {
                shakeCount = 0
                lastDirectionX = 0
                onShake()
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
}

package com.charan.themeify.feature_dashboard

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(val label: String, val icon: ImageVector)

val bottomNavItems = listOf(
    BottomNavItem("Home", Icons.Outlined.Home),
    BottomNavItem("Transactions", Icons.Outlined.Search),
    BottomNavItem("Budget", Icons.Outlined.Person),
    BottomNavItem("Settings", Icons.Outlined.Settings)
)

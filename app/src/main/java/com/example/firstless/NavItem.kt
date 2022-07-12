package com.example.firstless

import androidx.compose.ui.graphics.vector.ImageVector

class NavItem(
    val name:String,
    val route:String,
    val icon:ImageVector,
    val badgeCount:Int = 0
)
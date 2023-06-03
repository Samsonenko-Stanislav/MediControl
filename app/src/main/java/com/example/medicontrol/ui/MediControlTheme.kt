package com.example.medicontrol.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun MediControlTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = darkColors(
            primary = Color(0xFF2196F3),
            primaryVariant = Color(0xFF1976D2),
            secondary = Color(0xFFFF5722)
        ),
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

private val Typography: Typography = Typography()
private val Shapes: Shapes = Shapes()

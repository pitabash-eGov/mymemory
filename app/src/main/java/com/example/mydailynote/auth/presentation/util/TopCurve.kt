package com.example.mydailynote.auth.presentation.util

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable

fun TopCurve(modifier: Modifier){
    var width =  1000.toFloat()

    val height = 60.toFloat()
    androidx.compose.foundation.Canvas(modifier = modifier) {

        drawArc(

            color = Color.Green,  // Adjust the color as needed
            startAngle = 360f,  // Starts from the top (180 degrees)
            sweepAngle = 360f,  // Sweeps 180 degrees to form a half-circle/ellipse
            useCenter = false,  // Not using the center, just the edge
            topLeft = Offset(0f, height / 2),  // Move up by half of the height to make the arc symmetrical
            size = Size(width, height*2)  // Elliptical arc will be drawn over twice the height
        )
    }
}
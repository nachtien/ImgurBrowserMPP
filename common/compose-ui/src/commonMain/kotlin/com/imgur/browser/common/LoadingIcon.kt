package com.imgur.browser.common

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.rotate

private const val ANIMATION_DURATION = 1000

@Composable
private fun LoadingIconComponent(dotValue: Float, lineValue: Float) {
    Box {
        Canvas(
            modifier = Modifier.fillMaxSize(),
            onDraw = {
                rotate(dotValue, Offset(center.x, 550f)) {
                    drawCircle(
                        Color(28, 175, 103),
                        center = Offset(center.x, 325f),
                        radius = 40f,
                    )
                }
            }
        )

        Canvas(
            modifier = Modifier.fillMaxSize(),
            onDraw = {
                rotate(lineValue, Offset(center.x, 550f)) {
                    drawLine(
                        Color.White,
                        start = Offset(center.x, 450f),
                        end = Offset(center.x, 650f),
                        strokeWidth = 80f,
                        cap = StrokeCap.Round,
                    )
                }
            }
        )
    }
}

@Composable
fun LoadingIcon() {
    val dotValue = rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = ANIMATION_DURATION,
            )
        )
    )
    LoadingIconComponent(dotValue.value, -dotValue.value)
}

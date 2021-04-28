package com.achtien.imgurbrowser.android.ui.searchscreen

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private const val ANIMATION_DURATION = 1000

@Composable
fun JustALine(dotValue: Float, lineValue: Float) {
    Box {
        Canvas(modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
            onDraw = {
                rotate(dotValue, Offset(center.x, 550f)) {
                    drawCircle(
                        Color(28, 175, 103),
                        center = Offset(center.x, 325f),
                        radius = 40f,
                    )
                }
            })

        Canvas(modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
            onDraw = {
                rotate(lineValue, Offset(center.x, 550f)){
                    drawLine(
                        Color.White,
                        start = Offset(center.x, 450f),
                        end = Offset(center.x, 650f),
                        strokeWidth = 80f,
                        cap = StrokeCap.Round,
                    )
                }
            },
        )
    }
}

@Composable
@Preview
fun ImgurLogo() {
    Column(modifier = Modifier.height((128 * 3).dp)) {
        val dotValue = rememberInfiniteTransition().animateFloat(
            initialValue = 0f,
            targetValue = 360f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = ANIMATION_DURATION,
                )
        ))

        JustALine(dotValue.value, -dotValue.value)
    }
}
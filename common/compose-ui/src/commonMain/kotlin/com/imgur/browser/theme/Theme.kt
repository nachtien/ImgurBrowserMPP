package com.imgur.browser.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imgur.browser.common.Font

val Yellow800 = Color(0xFFF29F05)
val Red300 = Color(0xFFEA6D7E)

val MultiBlendColors = darkColors(
    primary = Yellow800,
    onPrimary = Color.Black,
    primaryVariant = Yellow800,
    secondary = Yellow800,
    onSecondary = Color.Black,
    error = Red300,
    onError = Color.Black
)

@Composable
private fun vagFontFamily() = FontFamily(Font("vag", "vag"))

@Composable
fun multiBlendTypography() = Typography(
    h1 = TextStyle(
        fontFamily = vagFontFamily(),
        fontSize = 96.sp,
        fontWeight = FontWeight.Light,
        lineHeight = 117.sp,
        letterSpacing = (-1.5).sp
    ),
    h2 = TextStyle(
        fontFamily = vagFontFamily(),
        fontSize = 60.sp,
        fontWeight = FontWeight.Light,
        lineHeight = 73.sp,
        letterSpacing = (-0.5).sp
    ),
    h3 = TextStyle(
        fontFamily = vagFontFamily(),
        fontSize = 48.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 59.sp
    ),
    h4 = TextStyle(
        fontFamily = vagFontFamily(),
        fontSize = 30.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 37.sp
    ),
    h5 = TextStyle(
        fontFamily = vagFontFamily(),
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 29.sp
    ),
    h6 = TextStyle(
        fontFamily = vagFontFamily(),
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 24.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = vagFontFamily(),
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 20.sp,
        letterSpacing = 0.5.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = vagFontFamily(),
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 17.sp,
        letterSpacing = 0.1.sp
    ),
    body1 = TextStyle(
        fontFamily = vagFontFamily(),
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 20.sp,
        letterSpacing = 0.15.sp
    ),
    body2 = TextStyle(
        fontFamily = vagFontFamily(),
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    button = TextStyle(
        fontFamily = vagFontFamily(),
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 16.sp,
        letterSpacing = 1.25.sp
    ),
    caption = TextStyle(
        fontFamily = vagFontFamily(),
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    ),
    overline = TextStyle(
        fontFamily = vagFontFamily(),
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 16.sp,
        letterSpacing = 1.sp
    )
)

val MultiBlendShapes = Shapes(
    small = RoundedCornerShape(percent = 50),
    medium = RoundedCornerShape(size = 8.dp),
    large = RoundedCornerShape(size = 0.dp)
)

@Composable
fun MultiBlendTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = MultiBlendColors,
        typography = multiBlendTypography(),
        shapes = MultiBlendShapes,
        content = content
    )
}

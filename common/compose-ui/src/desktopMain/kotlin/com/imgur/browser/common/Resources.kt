package com.imgur.browser.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font

@Composable
actual fun Font(name: String, res: String): Font =
    androidx.compose.ui.text.platform.Font("font/$res.ttf")
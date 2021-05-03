package com.imgur.browser.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font

@Composable
actual fun Font(name: String, res: String): Font {
    val context = LocalContext.current
    val id = context.resources.getIdentifier(res, "font", context.packageName)
    return Font(id)
}
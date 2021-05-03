package com.imgur.browser.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.imgur.browser.theme.multiBlendTypography
import io.kamel.image.KamelImage
import io.kamel.image.lazyImageResource

@Composable
fun NetworkImage(
    url: String,
    text: String,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { onClick() })
            .padding(1.dp)
    ) {
        val imageResource = lazyImageResource(data = url)
        KamelImage(
            resource = imageResource,
            onLoading = {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator()
                }
            },
            onFailure = {
                Box(modifier = Modifier.fillMaxSize()) {
                    Image(
                        Icons.Filled.Warning,
                        contentDescription = "Failed to load image",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            },
            contentDescription = null
        )
        Text(
            text = text,
            maxLines = 2,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .background(MaterialTheme.colors.onSurface.copy(alpha = .1f)),
            style = multiBlendTypography().caption
        )
    }
}
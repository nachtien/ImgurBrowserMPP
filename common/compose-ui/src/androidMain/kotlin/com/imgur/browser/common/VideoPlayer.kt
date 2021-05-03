package com.imgur.browser.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.MediaItem.fromUri
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView

@Composable
actual fun VideoPlayer(url: String, height: Int) {
    val context = LocalContext.current

    val exoPlayer = remember {
        SimpleExoPlayer.Builder(context).build().apply {
            setMediaItem(fromUri(url))
            repeatMode = Player.REPEAT_MODE_ONE
            prepare()
        }
    }

    AndroidView(
        { ctx ->
            PlayerView(ctx).apply {
                useController = false
                player = exoPlayer
                exoPlayer.playWhenReady = true
            }
        },
        modifier = Modifier
            .height(height.dp)
            .fillMaxWidth()
    )
}

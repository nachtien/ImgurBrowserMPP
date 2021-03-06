package com.achtien.imgurbrowser.android.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.ImageLoader
import com.achtien.imgurbrowser.android.R
import com.achtien.imgurbrowser.android.ui.theme.MultiBlendTypography
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.imageloading.ImageLoadState
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView

@Composable
fun NetworkImage(
    imageLoader: ImageLoader,
    url: String,
    text: String = "",
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    val painter = rememberCoilPainter(
        request = url,
        fadeIn = true,
        imageLoader = imageLoader
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { onClick() })
            .padding(1.dp)
    ) {
        when (painter.loadState) {
            is ImageLoadState.Loading -> CircularProgressIndicator(Modifier.align(Alignment.Center))
            is ImageLoadState.Error -> Image(
                painterResource(R.drawable.ic_sad_face),
                contentDescription = "Failed to load image"
            )
            is ImageLoadState.Success -> {
                Image(
                    painter = painter,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                )
                Text(
                    text = text,
                    maxLines = 2,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .background(colorResource(id = R.color.text_tile_background)),
                    style = MultiBlendTypography.caption
                )
            }
        }
    }
}

@Composable
fun VideoPlayer(url: String, height: Int) {
    val context = LocalContext.current

    val exoPlayer = remember {
        SimpleExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(url))
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

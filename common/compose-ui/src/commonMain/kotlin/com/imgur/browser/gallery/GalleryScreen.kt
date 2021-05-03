package com.imgur.browser.gallery

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.imgur.browser.common.NetworkImage
import com.imgur.browser.common.VideoPlayer

@Composable
fun GalleryScreen(viewModel: GalleryViewModel = GalleryViewModel(), galleryId: String, upPress: () -> Unit) {
    viewModel.getGallery(galleryId)
    val galleryState = viewModel.galleryState.collectAsState()
    val gallery = galleryState.value
    Scaffold(
        topBar = {
            GalleryTopBar(title = gallery?.data?.title ?: "", upPress)
        }
    ) {
        LazyColumn {
            gallery?.data?.images?.let { images ->
                items(images) { image ->
                    if (image.type.contains("mp4")) {
                        VideoPlayer(url = image.mp4, image.height)
                    } else {
                        NetworkImage(image.link, text = image.description) {}
                    }
                }
            }
        }
    }
}

@Composable
private fun GalleryTopBar(title: String, upPress: () -> Unit) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = upPress) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = null
                )
            }
        }
    )
}

@Composable
private fun GalleryTopBar() {
    GalleryTopBar("Imgur Browser") {}
}

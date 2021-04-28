package com.achtien.imgurbrowser.android.ui.galleryscreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.achtien.imgurbrowser.android.Graph.imageLoader
import com.achtien.imgurbrowser.android.R
import com.achtien.imgurbrowser.android.ui.common.NetworkImage
import com.achtien.imgurbrowser.android.ui.common.VideoPlayer

@Composable
fun GalleryScreen(viewModel: AlbumViewModel = viewModel(), galleryId: String, upPress: () -> Unit) {
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
                        NetworkImage(imageLoader, image.link) {}
                    }
                    Text(image.description, modifier = Modifier.fillMaxWidth())
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
                    contentDescription = stringResource(R.string.label_back)
                )
            }
        }
    )
}

@Preview
@Composable
private fun GalleryTopBar() {
    GalleryTopBar("Imgur Browser") {}
}

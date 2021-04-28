package com.achtien.imgurbrowser.android.ui.searchscreen

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.achtien.imgurbrowser.android.Graph.imageLoader
import com.achtien.imgurbrowser.android.ui.common.NetworkImage
import com.achtien.imgurbrowser.remote.GalleryItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchScreen(
    viewModel: SearchGalleryViewModel = viewModel(),
    onGallerySelected: (String) -> Unit
) {
    val galleriesState = viewModel.galleriesState.collectAsState()
    val isLoading = viewModel.isLoading.collectAsState()

    Scaffold(topBar = { SearchBar(viewModel) }) {
        val galleries = galleriesState.value
        if (isLoading.value) {
            ImgurLoadingAnimation()
        } else if (galleries?.data != null && galleries.data.isNotEmpty()) {
            LazyVerticalGrid(
                cells = GridCells.Adaptive(minSize = 128.dp)
            ) {
                items(galleries.data) { gallery ->
                    ItemView(gallery = gallery, onGallerySelected)
                }
            }
        }
    }
}

@Composable
private fun ItemView(gallery: GalleryItem, onItemSelected: (galleryId: String) -> Unit) {
    val context = LocalContext.current
    val cover =
        if (gallery.is_album) "https://i.imgur.com/${gallery.cover}.jpg" else gallery.link
    NetworkImage(
        imageLoader,
        cover,
        gallery.title,
        onClick = {
            if (gallery.is_album) {
                onItemSelected(gallery.id)
            } else {
                Toast.makeText(
                    context,
                    "Single images not supported",
                    Toast.LENGTH_SHORT
                ).show()
            }
        },
        modifier = Modifier.height(100.dp)
    )
}

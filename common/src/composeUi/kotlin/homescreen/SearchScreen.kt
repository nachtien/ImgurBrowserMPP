package homescreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import common.NetworkImage
import imgurbrowser.remote.GalleryItem
import imgurbrowser.ui.searchscreen.ImgurLoadingAnimation
import imgurbrowser.ui.searchscreen.SearchBar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchScreen(
    viewModel: SearchGalleryViewModel = SearchGalleryViewModel(),
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
                    CoverView(gallery = gallery, onGallerySelected)
                }
            }
        }
    }
}

@Composable
private fun CoverView(gallery: GalleryItem, onItemSelected: (galleryId: String) -> Unit) {
    val cover =
        if (gallery.is_album) "https://i.imgur.com/${gallery.cover}.jpg" else gallery.link
    NetworkImage(
        cover,
        gallery.title,
        onClick = {
            if (gallery.is_album) {
                onItemSelected(gallery.id)
            } else {
                // TODO: Expand single image
            }
        },
        modifier = Modifier.height(100.dp)
    )
}

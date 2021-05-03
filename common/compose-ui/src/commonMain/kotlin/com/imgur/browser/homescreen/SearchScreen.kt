package com.imgur.browser.homescreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import com.imgur.browser.common.LoadingIcon
import com.imgur.browser.common.NetworkImage
import com.imgur.browser.search.SearchGalleryViewModel
import imgur.ui.searchscreen.SearchBar

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
            LoadingIcon()
        } else if (galleries?.data != null && galleries.data.isNotEmpty()) {
            LazyVerticalGrid(
                cells = GridCells.Adaptive(minSize = 128.dp)
            ) {
                items(galleries.data) { gallery ->
                    NetworkImage(
                        if (gallery.is_album) "https://i.imgur.com/${gallery.cover}s.jpg" else gallery.link,
                        gallery.title
                    )
                    {
                        if (gallery.is_album) {
                            onGallerySelected(gallery.id)
                        } else {
                            // TODO: Expand single image
                        }
                    }
                }
            }
        }
    }
}
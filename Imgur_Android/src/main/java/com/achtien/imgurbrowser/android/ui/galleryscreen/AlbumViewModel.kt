package com.achtien.imgurbrowser.android.ui.galleryscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.achtien.imgurbrowser.android.Graph.imgurRepository
import com.achtien.imgurbrowser.remote.Gallery
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class AlbumViewModel : ViewModel() {
    private val _galleryState = MutableStateFlow<Gallery?>(null)
    val galleryState = _galleryState.asStateFlow()

    private val galleryId = MutableStateFlow("")

    init {
        galleryId
            .filter { it.isNotEmpty() }
            .onEach { galleryId ->
                _galleryState.value = imgurRepository.getGallery(galleryId)
            }
            .launchIn(viewModelScope)
    }

    fun getGallery(galleryId: String) {
        this.galleryId.value = galleryId
    }
}

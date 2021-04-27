package com.achtien.imgurbrowser.android.ui.searchscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import com.achtien.imgurbrowser.android.Graph.imgurRepository
import com.achtien.imgurbrowser.remote.Galleries

class SearchGalleryViewModel : ViewModel() {
    private val _galleriesState = MutableStateFlow<Galleries?>(null)
    val galleriesState = _galleriesState.asStateFlow()

    private val searchQuery = MutableStateFlow("")

    init {
        searchQuery
            .filter { it.isNotEmpty() }
            .debounce(200L)
            .onEach { query ->
                _galleriesState.value = imgurRepository.searchForGallery(query)
            }
            .launchIn(viewModelScope)
    }

    fun searchGalleries(query: String) {
        searchQuery.value = query
    }
}
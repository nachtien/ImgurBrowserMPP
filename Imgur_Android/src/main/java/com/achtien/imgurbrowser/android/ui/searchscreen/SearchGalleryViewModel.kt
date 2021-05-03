package com.achtien.imgurbrowser.android.ui.searchscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.achtien.imgurbrowser.android.Graph.imgurRepository
import com.achtien.imgurbrowser.remote.GalleryItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class SearchGalleryViewModel : ViewModel() {
    private val _galleriesState = MutableStateFlow<Flow<PagingData<GalleryItem>>?>(null)
    val galleriesState = _galleriesState.asStateFlow()
    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()


    private val searchQuery = MutableStateFlow("")

    init {
        searchQuery
            .filter { it.isNotEmpty() }
            .debounce(200L) // to save network traffic
            .onEach { query ->
                _galleriesState.value = Pager(
                    PagingConfig(50)
                ) {
                    GalleryPagingSource(imgurRepository, query)
                }.flow.cachedIn(viewModelScope)
            }
            .launchIn(viewModelScope)
    }

    fun searchGalleries(query: String) {
        // Let's add a delay so we can show off the pretty loading indicator
        viewModelScope.launch {
            _isLoading.value = true
            searchQuery.value = query
            delay(2000)
            _isLoading.value = false
        }
    }
}

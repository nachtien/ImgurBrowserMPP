package com.imgur.browser.search

import com.imgur.browser.Graph.imgurRepository
import com.imgur.browser.remote.Galleries
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class SearchGalleryViewModel(private val scope: CoroutineScope) {
    private val _galleriesState = MutableStateFlow<Galleries?>(null)
    val galleriesState = _galleriesState.asStateFlow()
    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val searchQuery = MutableStateFlow("")

    init {
        searchQuery
            .filter { it.isNotEmpty() }
            .debounce(200L) // to save network traffic
            .onEach { query ->
                try {
                    _galleriesState.value = imgurRepository.searchForGallery(query)
                } catch (ex: Exception) {
                    println("error")
                }
            }
            .launchIn(scope)
    }

    fun searchGalleries(query: String) {
        // Let's add a delay so we can show off the pretty loading indicator
        scope.launch {
            _isLoading.value = true
            searchQuery.value = query
            delay(2000)
            _isLoading.value = false
        }
    }
}

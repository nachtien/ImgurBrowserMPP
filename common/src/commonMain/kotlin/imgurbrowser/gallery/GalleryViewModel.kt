package imgurbrowser.gallery

import imgurbrowser.Graph.imgurRepository
import imgurbrowser.remote.Gallery
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class GalleryViewModel {
    private val _galleryState = MutableStateFlow<Gallery?>(null)
    val galleryState = _galleryState.asStateFlow()

    private val galleryId = MutableStateFlow("")

    private val scope = CoroutineScope(Dispatchers.Unconfined)

    init {
        galleryId
            .filter { it.isNotEmpty() }
            .onEach { galleryId ->
                _galleryState.value = imgurRepository.getGallery(galleryId)
            }
            .launchIn(scope)
    }

    fun getGallery(galleryId: String) {
        this.galleryId.value = galleryId
    }

    fun onDestroy() {
        scope.cancel()
    }
}

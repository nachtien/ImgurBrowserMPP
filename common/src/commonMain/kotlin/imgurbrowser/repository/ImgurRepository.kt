package imgurbrowser.repository

import imgurbrowser.remote.Galleries
import imgurbrowser.remote.ImgurApi

class ImgurRepository(private val imgurApi: ImgurApi) {
    suspend fun searchForGallery(query: String): Galleries = imgurApi.searchForGallery(query)
    suspend fun getGallery(galleryId: String) = imgurApi.getGallery(galleryId)
}

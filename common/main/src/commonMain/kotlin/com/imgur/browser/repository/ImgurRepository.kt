package com.imgur.browser.repository

import com.imgur.browser.remote.Galleries
import com.imgur.browser.remote.ImgurApi

class ImgurRepository(private val imgurApi: ImgurApi) {
    suspend fun searchForGallery(query: String): Galleries = imgurApi.searchForGallery(query)
    suspend fun getGallery(galleryId: String) = imgurApi.getGallery(galleryId)
}

package com.achtien.imgurbrowser.repository

import com.achtien.imgurbrowser.remote.Galleries
import com.achtien.imgurbrowser.remote.ImgurApi

class ImgurRepository(private val imgurApi: ImgurApi) {
    suspend fun searchForGallery(query: String) : Galleries = imgurApi.searchForGallery(query)
    suspend fun getGallery(galleryId: String) = imgurApi.getGallery(galleryId)
}
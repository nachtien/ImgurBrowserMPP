package com.achtien.imgurbrowser.remote


import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.get
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.Serializable

private const val CLIENT_ID = "6685dd82a89f8ec"
private const val BASE_URL = "https://api.imgur.com/3"

@Serializable
data class Galleries(val data: List<GalleryItem> = listOf())

@Serializable
data class Gallery(val data: GalleryItem)

@Serializable
data class GalleryItem(
    val id: String,
    val title: String,
    val cover: String = "",
    val link: String = "",
    val is_album: Boolean,
    val description: String = "",
    val images: List<Image> = listOf()
)

@Serializable
data class Image(
    val link: String = "",
    val id: String,
    val type: String,
    val description: String = "",
    val mp4: String = "",
    val width: Int = 0,
    val height: Int = 0
)

class ImgurApi {
    private val client = HttpClient() {
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                prettyPrint = true
                ignoreUnknownKeys = true
                coerceInputValues = true
                isLenient = true
            })
        }
        defaultRequest {
            header(HttpHeaders.Authorization, "Client-ID $CLIENT_ID")
        }
    }

    suspend fun searchForGallery(query: String) =
        client.get<Galleries>("$BASE_URL/gallery/search?q=$query")

    suspend fun getGallery(galleryId: String) =
        client.get<Gallery>("$BASE_URL/gallery/album/$galleryId")
}
package com.achtien.imgurbrowser.android

import android.content.Context
import android.os.Build
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.achtien.imgurbrowser.remote.ImgurApi
import com.achtien.imgurbrowser.repository.ImgurRepository

/**
 * A very simple global singleton dependency graph.
 *
 * For a real app, you would use something like Hilt/Dagger, or for MPP, use koin instead.
 */
object Graph {
    val imgurApi by lazy { ImgurApi() }
    val imgurRepository by lazy { ImgurRepository(imgurApi) }
    lateinit var imageLoader: ImageLoader
    fun provide(context: Context) {
        imageLoader = ImageLoader.Builder(context)
            .componentRegistry {
                if (Build.VERSION.SDK_INT >= 28) {
                    add(ImageDecoderDecoder(context))
                } else {
                    add(GifDecoder())
                }
            }
            .build()
    }
}

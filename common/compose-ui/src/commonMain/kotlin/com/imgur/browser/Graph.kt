package com.imgur.browser

import com.imgur.browser.remote.ImgurApi
import com.imgur.browser.repository.ImgurRepository

/**
 * A very simple global singleton dependency graph.
 *
 * For a real app, you would use something like Hilt/Dagger, or for MPP, use koin instead.
 */
object Graph {
    val imgurApi by lazy { ImgurApi() }
    val imgurRepository by lazy { ImgurRepository(imgurApi) }
}
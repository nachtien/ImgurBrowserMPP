package com.achtien.imgurbrowser.android

import android.app.Application

/**
 * Application which sets up our dependency [Graph] with a context.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}

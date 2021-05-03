package com.imgur.browser.common

import androidx.compose.desktop.SwingPanel
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import uk.co.caprica.vlcj.factory.discovery.NativeDiscovery
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent

@Composable
actual fun VideoPlayer(url: String, height: Int) {
    NativeDiscovery().discover()
    // Doesn't work on macOS, see https://github.com/caprica/vlcj/issues/887 for suggestions.
    val mediaPlayerComponent = remember { EmbeddedMediaPlayerComponent() }
    SideEffect {
        mediaPlayerComponent.release()
        val ok = mediaPlayerComponent.mediaPlayer().media().play(url)
        println("play gave $ok")
    }
    return SwingPanel(
        background = Color.Transparent,
        modifier = Modifier.fillMaxSize(),
        factory = {
            mediaPlayerComponent
        }
    )
}
//package com.imgur.browser.common
//
//import androidx.compose.runtime.Composable
//
//@Composable
//actual fun VideoPlayer(url: String, height: Int) {
////    NativeDiscovery().discover()
////    // Doesn't work on macOS, see https://github.com/caprica/vlcj/issues/887 for suggestions.
////    val mediaPlayerComponent = remember { EmbeddedMediaPlayerComponent() }
////    SideEffect {
////        mediaPlayerComponent.release()
////        val ok = mediaPlayerComponent.mediaPlayer().media().play(url)
////        println("play gave $ok")
////    }
////    return SwingPanel(
////        background = Color.Transparent,
////        modifier = Modifier.fillMaxSize(),
////        factory = {
////            mediaPlayerComponent
////        }
////    )
//}
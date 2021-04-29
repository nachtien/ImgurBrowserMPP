object Versions {
    const val kotlin = "1.4.32"
    const val kotlinCoroutines = "1.5.0-RC"
    const val ktor = "1.5.3"
    const val kotlinxSerialization = "1.1.0"
    const val kermit = "0.1.8"
    const val exoplayer = "2.13.3"

    const val slf4j = "1.7.30"
    const val compose = "1.0.0-beta05"
    const val nav_compose = "1.0.0-alpha10"
    const val accompanist = "0.8.1"
    const val coilExtensionLibrary = "1.2.0"

    const val junit = "4.13"
    const val testRunner = "1.3.0"
}

object AndroidSdk {
    const val min = 21
    const val compile = 29
    const val target = compile
}

object Compose {
    const val ui = "androidx.compose.ui:ui:${Versions.compose}"
    const val uiGraphics = "androidx.compose.ui:ui-graphics:${Versions.compose}"
    const val compiler = "androidx.compose.compiler:compiler:1.0.0-alpha03"
    const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val foundationLayout = "androidx.compose.foundation:foundation-layout:${Versions.compose}"
    const val material = "androidx.compose.material:material:${Versions.compose}"
    const val runtimeLiveData = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
    const val navigation = "androidx.navigation:navigation-compose:${Versions.nav_compose}"
    const val accompanist = "com.google.accompanist:accompanist-coil:${Versions.accompanist}"
}

object Exoplayer {
    const val exoPlayerCore = "com.google.android.exoplayer:exoplayer-core:${Versions.exoplayer}"
    const val exoPlayerUi = "com.google.android.exoplayer:exoplayer-ui:${Versions.exoplayer}"
}

object Coil {
    const val coilGif = "io.coil-kt:coil-gif:${Versions.coilExtensionLibrary}"
    const val coilVideo = "io.coil-kt:coil-video:${Versions.coilExtensionLibrary}"
}

object Kotlin {
    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
}

object Ktor {
    val clientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
    val clientJson = "io.ktor:ktor-client-json:${Versions.ktor}"
    val clientLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
    val clientSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"

    val clientAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
    val clientIos = "io.ktor:ktor-client-ios:${Versions.ktor}"
}

object Serialization {
    val core = "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.kotlinxSerialization}"
}

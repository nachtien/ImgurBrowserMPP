object Versions {
    const val kotlin = "1.4.32"
    const val kotlinCoroutines = "1.5.0-RC"
    const val ktor = "1.5.3"
    const val kotlinxSerialization = "1.1.0"
    const val exoplayer = "2.13.3"

    const val compose = "1.0.0-beta05"
    const val composeActivity = "1.3.0-alpha07"
    const val nav_compose = "1.0.0-alpha10"
    const val accompanist = "0.8.1"
    const val coilExtensionLibrary = "1.2.0"
}

object AndroidSdk {
    const val min = 21
    const val compile = 29
    const val target = compile
}

object Compose {
    const val activity = "androidx.activity:activity-compose:${Versions.composeActivity}"
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
    const val clientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
    const val clientJson = "io.ktor:ktor-client-json:${Versions.ktor}"
    const val clientLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
    const val clientSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"

    const val clientAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
    const val clientIos = "io.ktor:ktor-client-ios:${Versions.ktor}"
}

object Serialization {
    const val core =
        "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.kotlinxSerialization}"
}

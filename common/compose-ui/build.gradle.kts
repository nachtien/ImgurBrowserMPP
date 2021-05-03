plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}
kotlin {
    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(project(":common:main"))
                implementation(Kamel.kamel)

                implementation(Kotlin.coroutines)

                // Ktor
                implementation(Ktor.clientCore)
                implementation(Ktor.clientCio)
                implementation(Ktor.clientJson)
                implementation(Ktor.clientLogging)
                implementation(Ktor.clientSerialization)

                // Kotlinx Serialization
                implementation(Serialization.core)
            }
        }
        named("androidMain") {
            resources.srcDirs("src/commonMain/resources")
            dependencies {
                implementation(Exoplayer.exoPlayerCore)
                implementation(Exoplayer.exoPlayerUi)
                implementation(Compose.accompanist)
            }
        }
        named("desktopMain") {
//            resources.srcDirs("src/commonMain/resources")
            dependencies {
                implementation(Compose.uiTooling)
                implementation(compose.desktop.currentOs)
                implementation(Vlc.vlcj)
            }
        }
    }
}

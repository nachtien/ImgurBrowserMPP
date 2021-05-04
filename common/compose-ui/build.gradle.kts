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
            dependencies {
                implementation(Compose.uiTooling)
                implementation(compose.desktop.currentOs)
                implementation(Vlc.vlcj)
            }
        }
    }
}

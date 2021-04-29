import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("kotlinx-serialization")
    id("org.jetbrains.compose")
}

version = "1.0"

kotlin {
    org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType.jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    val sdkName: String? = System.getenv("SDK_NAME")
    val isiOSDevice = sdkName.orEmpty().startsWith("iphoneos")
    if (isiOSDevice) {
        iosArm64("iOS")
    } else {
        iosX64("iOS")
    }

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        frameworkName = "common"
        podfile = project.file("../imgur_iOS/Podfile")
    }

    sourceSets {
        sourceSets["desktopMain"].dependencies {
            api(compose.desktop.common)
            implementation("io.ktor:ktor-client-cio:1.5.3")
        }

        create("composeUi").apply {
            dependsOn(sourceSets["commonMain"])
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                implementation(Compose.uiTooling)
                implementation(Coil.coilGif)
                implementation(Exoplayer.exoPlayerCore)
                implementation(Exoplayer.exoPlayerUi)
                implementation(Compose.accompanist)
            }
        }

        sourceSets["commonMain"].apply {
            dependencies {
                api(Kotlin.coroutines)

                // Ktor
                implementation(Ktor.clientCore)
                implementation(Ktor.clientJson)
                implementation(Ktor.clientLogging)
                implementation(Ktor.clientSerialization)

                // Kotlinx Serialization
                implementation(Serialization.core)
            }
        }

        sourceSets["iOSMain"].dependencies {
            implementation(Ktor.clientIos)
        }
    }
}

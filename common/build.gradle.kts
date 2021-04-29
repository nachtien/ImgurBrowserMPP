import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("kotlinx-serialization")
    id("org.jetbrains.compose")
}

version = "1.0"

android {
    compileSdkVersion(30)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(23)
        targetSdkVersion(30)
    }

//     https://stackoverflow.com/questions/65372825/kotlin-multiplatform-configuration-issue
    configurations {
        create("androidTestApi")
        create("androidTestDebugApi")
        create("androidTestReleaseApi")
        create("testApi")
        create("testDebugApi")
        create("testReleaseApi")
    }
}

kotlin {
    android()
    jvm("desktop") {
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
        sourceSets["androidMain"].apply {
            dependencies {
                implementation(Ktor.clientAndroid)
                implementation("androidx.compose.runtime:runtime:${Versions.compose}")

                implementation("com.google.android.material:material:1.3.0")
                implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0-alpha01")
                implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0-alpha01")
//                implementation("androidx.activity:activity-compose:1.3.0-alpha07")
//
//                implementation(Compose.ui)
//                implementation(Compose.uiGraphics)
//                implementation(Compose.uiTooling)
//                implementation(Compose.foundationLayout)
//                implementation(Compose.material)
//                implementation(Compose.runtimeLiveData)
//                implementation(Compose.navigation)
//                implementation(Compose.accompanist)
//                implementation(Compose.compiler)

                implementation("org.osmdroid:osmdroid-android:6.1.10")
                implementation(Coil.coilGif)

            }
            dependsOn(sourceSets["composeUi"])
            dependsOn(sourceSets["commonMain"])
        }

        sourceSets["iOSMain"].dependencies {
            implementation(Ktor.clientIos)
        }
    }
}

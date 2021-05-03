//import org.jetbrains.compose.compose
//
//plugins {
//    id("com.android.library")
//    kotlin("multiplatform")
//    id("org.jetbrains.compose")
//    kotlin("native.cocoapods")
//    id("kotlinx-serialization")
//}
//
//version = "1.0"
//
//android {
//    compileSdkVersion(30)
//    defaultConfig {
//        minSdkVersion(24)
//        targetSdkVersion(30)
//        versionCode = 1
//        versionName = "1.0"
//    }
//
//    buildFeatures {
//        compose = true
//    }
//
//    composeOptions {
//        kotlinCompilerExtensionVersion = "1.0.0-beta05"
//    }
//
//    // https://stackoverflow.com/questions/65372825/kotlin-multiplatform-configuration-issue
//    configurations {
//        create("androidTestApi")
//        create("androidTestDebugApi")
//        create("androidTestReleaseApi")
//        create("testApi")
//        create("testDebugApi")
//        create("testReleaseApi")
//    }
//
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_1_8
//        targetCompatibility = JavaVersion.VERSION_1_8
//    }
//
//    sourceSets {
//        named("main") {
//            manifest.srcFile("src/androidMain/AndroidManifest.xml")
//            res.srcDirs("src/androidMain/res", "src/composeUi/resources")
//        }
//    }
//}
//
//kotlin {
//    android()
//
//    jvm("desktop") {
//        compilations.all {
//            kotlinOptions.jvmTarget = "11"
//        }
//    }
//    val sdkName: String? = System.getenv("SDK_NAME")
//    val isiOSDevice = sdkName.orEmpty().startsWith("iphoneos")
//    if (isiOSDevice) {
//        iosArm64("iOS")
//    } else {
//        iosX64("iOS")
//    }
//
//    cocoapods {
//        summary = "Some description for the Shared Module"
//        homepage = "Link to the Shared Module homepage"
//        ios.deploymentTarget = "14.1"
//        frameworkName = "com/imgur/browser/common"
//        podfile = project.file("../imgur_iOS/Podfile")
//    }
//
//    sourceSets {
//        sourceSets["desktopMain"].dependencies {
//            api(compose.desktop.common)
//            implementation("io.ktor:ktor-client-cio:1.5.3")
//        }
//
//        create("composeUi").apply {
//            dependencies {
//                api(compose.runtime)
//                api(compose.foundation)
//                api(compose.material)
//                implementation(Compose.activity)
//                implementation(Compose.uiTooling)
//                implementation(Coil.coilGif)
//                implementation(Exoplayer.exoPlayerCore)
//                implementation(Exoplayer.exoPlayerUi)
//                implementation(Compose.accompanist)
//            }
//            resources.srcDirs("src/composeUi/resources")
//        }
//
//        sourceSets["androidMain"].apply {
//            dependsOn(sourceSets["composeUi"])
//            dependencies {
//                api("androidx.appcompat:appcompat:1.3.0-beta01")
//                api("androidx.core:core-ktx:1.3.1")
//                implementation("io.ktor:ktor-client-cio:1.4.1")
//                implementation(Compose.activity)
//            }
//        }
//
//        sourceSets["commonMain"].apply {
//            dependencies {
//                api(Kotlin.coroutines)
//
//                // Ktor
//                implementation(Ktor.clientCore)
//                implementation(Ktor.clientJson)
//                implementation(Ktor.clientLogging)
//                implementation(Ktor.clientSerialization)
//
//                // Kotlinx Serialization
//                implementation(Serialization.core)
//            }
//        }
//
//        sourceSets["iOSMain"].dependencies {
//            implementation(Ktor.clientIos)
//        }
//    }
//}

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
}

group = "me.nickachtien"
version = "1.0"

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.imgurbrowser"
        minSdkVersion(24)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerVersion = "1.4.32"
        kotlinCompilerExtensionVersion = "1.0.0-beta05"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
}


dependencies {
    api("androidx.appcompat:appcompat:1.2.0")
    api("androidx.core:core-ktx:1.3.2")
    implementation(Compose.activity)
//    implementation("androidx.compose.compiler:compiler:1.0.0-beta05")
//    implementation("androidx.compose.runtime:runtime:${Versions.compose}")
//
//    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0-alpha01")
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0-alpha01")
//    implementation("androidx.activity:activity-compose:1.3.0-alpha07")
//
//    implementation(Compose.ui)
//    implementation(Compose.uiGraphics)
//    implementation(Compose.uiTooling)
//    implementation(Compose.foundationLayout)
//    implementation(Compose.material)
//    implementation(Compose.runtimeLiveData)
    implementation(Compose.navigation)
//    implementation(Compose.accompanist)
//    implementation(Exoplayer.exoPlayerCore)
//    implementation(Coil.coilGif)
//    implementation(Coil.coilVideo)
//
    implementation(project(":common"))
}

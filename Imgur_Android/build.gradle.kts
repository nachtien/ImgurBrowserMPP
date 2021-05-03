plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
    id("org.jetbrains.compose")
}

group = "com.imgurbrowser.android"
version = "1.0"

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.imgurbrowser.android"
        minSdkVersion(24)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
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
    implementation(project(":common:compose-ui"))
    api("androidx.appcompat:appcompat:1.2.0")
    api("androidx.core:core-ktx:1.3.2")
    implementation(Compose.activity)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0-alpha01")
    implementation(Compose.navigation)
}

plugins {
    id("com.android.library")
    id("kotlin-multiplatform")
}

kotlin {
    jvm("desktop")
    android()
    ios()

    sourceSets {

    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}

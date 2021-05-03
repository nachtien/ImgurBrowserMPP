import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("plugin.serialization") version "1.5.0"
}

kotlin {
    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(Kotlin.coroutines)

                // Ktor
                implementation(Ktor.clientCore)
                implementation(Ktor.clientJson)
                implementation(Ktor.clientLogging)
                implementation(Ktor.clientSerialization)

                // Kotlinx Serialization
                implementation(Serialization.core)
            }
        }
    }

    targets.getByName<KotlinNativeTarget>("iosX64").compilations.forEach {
        it.kotlinOptions.freeCompilerArgs += arrayOf("-linker-options", "-lsqlite3")
    }
}

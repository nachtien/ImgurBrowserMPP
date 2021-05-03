//buildscript {
//    repositories {
//        mavenLocal().mavenContent {
//            includeModule("org.jetbrains.compose", "compose-gradle-plugin")
//        }
//        gradlePluginPortal()
//        google()
//        mavenCentral()
//        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
//    }
//    dependencies {
//        classpath("org.jetbrains.compose:compose-gradle-plugin:0.4.0-build182")
//        classpath("com.android.tools.build:gradle:7.0.0-alpha14")
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
//        classpath("org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}")
//        classpath(kotlin("gradle-plugin", version = Versions.kotlin))
//    }
//}
//
//allprojects {
//    repositories {
//        google()
//        mavenCentral()
//        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
//    }
//}
//
//plugins {
//    id("com.vanniktech.dependency.graph.generator") version "0.5.0"
//}

plugins {
    `kotlin-dsl`
}

allprojects {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

plugins {
    `kotlin-dsl`
}

repositories {
    mavenLocal()
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation("org.jetbrains.compose:compose-gradle-plugin:0.4.0-build183")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.32")
    implementation("com.android.tools.build:gradle:4.0.1")
}

kotlin {
    // Add Deps to compilation, so it will become available in main project
    sourceSets.getByName("main").kotlin.srcDir("buildSrc/src/main/kotlin")
}

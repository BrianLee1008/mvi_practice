import org.gradle.internal.impldep.junit.runner.Version.id

plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`

}

repositories {
    google()
    jcenter()
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://plugins.gradle.org/m2/")
    maven("https://ci.android.com/builds/submitted/5837096/androidx_snapshot/latest/repository")
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

object PluginsVersions {
    const val APPLICATION = "7.2.1"
    const val GRADLE_ANDROID = "7.1.2"
    const val GRADLE_VERSIONS = "0.39.0"
    const val KOTLIN = "1.7.0"
}

dependencies {
    implementation("com.android.tools.build:gradle:${PluginsVersions.GRADLE_ANDROID}")
    implementation("com.github.ben-manes:gradle-versions-plugin:${PluginsVersions.GRADLE_VERSIONS}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginsVersions.KOTLIN}")
}

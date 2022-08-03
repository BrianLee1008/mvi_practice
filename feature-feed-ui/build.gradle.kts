plugins {
    id("ui-precompiled")
}

dependencies {
    implementation(project(":shared-common-domain"))
    implementation(project(":shared-common-ui"))
    implementation(project(":shared-foundation"))

    implementation(project(":feature-feed-domain"))
}

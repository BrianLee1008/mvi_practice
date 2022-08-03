plugins {
    id("domain-precompiled")
}

dependencies {
    implementation(project(":shared-common-data"))
    implementation(project(":shared-common-domain"))
    implementation(project(":shared-foundation"))

    implementation(project(":feature-feed-data"))
}
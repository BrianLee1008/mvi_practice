import dependencies.Compose
import dependencies.Hilt
import dependencies.Versions

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 23
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

}

dependencies {
    implementation(project(":shared-common-data"))

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("com.google.android.material:material:1.6.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    // Compose
    implementation(Compose.COMPOSE_ACTIVITY)
    implementation(Compose.COMPOSE_VIEWMODEL)
    implementation(Compose.COMPOSE_UI_TOOLING)
    implementation(Compose.COMPOSE_ANIMATION)
    implementation(Compose.COMPOSE_COMPILER)
    implementation(Compose.COMPOSE_UI)
    implementation(Compose.COMPOSE_RUNTIME)
    implementation(Compose.COMPOSE_FOUNDATION)
    implementation(Compose.COMPOSE_FOUNDATION_LAYOUT)
    implementation(Compose.COMPOSE_COIL)
    implementation(Compose.MATERIAL)

    // Hilt
    implementation(Hilt.CORE)
    implementation(Hilt.NAVIGATION_COMPOSE)
    kapt(Hilt.APT)
}
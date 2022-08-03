package dependencies


object Compose {
    const val COMPOSE_ACTIVITY = "androidx.activity:activity-compose:${Versions.ANDROIDX_FRAGMENT}"
    const val COMPOSE_ANIMATION = "androidx.compose.animation:animation:${Versions.COMPOSE}"
    const val COMPOSE_UI_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE_UI_TOOLING}"
//    const val COMPOSE_UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE_UI_TOOLING}"
    const val COMPOSE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.LIFECYCLE}"
    const val COMPOSE_COMPILER = "androidx.compose.compiler:compiler:${Versions.COMPOSE}"
    const val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.COMPOSE}"
    const val COMPOSE_RUNTIME = "androidx.compose.runtime:runtime:${Versions.COMPOSE}"
    const val COMPOSE_FOUNDATION = "androidx.compose.foundation:foundation:${Versions.COMPOSE}"
    const val COMPOSE_FOUNDATION_LAYOUT = "androidx.compose.foundation:foundation-layout:${Versions.COMPOSE}"
    const val COMPOSE_COIL = "io.coil-kt:coil-compose:2.1.0"
    const val MATERIAL = "androidx.compose.material:material:${Versions.COMPOSE}"
    const val COMPOSE_VIEW_BINDING = "androidx.compose.ui:ui-viewbinding:${Versions.COMPOSE}"
    const val COMPOSE_CONSTRAINT = "androidx.constraintlayout:constraintlayout-compose:${Versions.COMPOSE_CONSTRAINT}"
    const val COMPOSE_VIEWBINDING = "androidx.compose.ui:ui-viewbinding:${Versions.COMPOSE}"
}

object Hilt {
    const val CORE = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val APT = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
    const val NAVIGATION_COMPOSE = "androidx.hilt:hilt-navigation-compose:${Versions.HILT_NAVIGATION_COMPOSE}"
}
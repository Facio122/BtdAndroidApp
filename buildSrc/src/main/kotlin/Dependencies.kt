import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
    //Koin
    const val koin = "io.insert-koin:koin-core:${Versions.koinVersion}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koinVersion}"
    const val koinAnnotations = "io.insert-koin:koin-annotations:${Versions.koinAnnotationsVersion}"
    const val koinKtor = "io.insert-koin:koin-ktor:${Versions.koinVersion}"
    const val koinLogger = "io.insert-koin:koin-logger-slf4j:${Versions.koinVersion}"
    const val koinCompose = "io.insert-koin:koin-androidx-compose:${Versions.koinVersion}"

    //compose
    const val composeBom = "androidx.compose:compose-bom:2024.09.01"
    const val composeUi = "androidx.compose.ui:ui"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeMaterial3 = "androidx.compose.material3:material3"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.composeVersion}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling"
    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest"

    //retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.gsonVersion}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpVersion}"
}

fun DependencyHandler.koin() {
    implementationPlatform(Dependencies.composeBom)
    implementation(Dependencies.koin)
    implementation(Dependencies.koinAndroid)
    implementation(Dependencies.koinAnnotations)
    implementation(Dependencies.koinKtor)
    implementation(Dependencies.koinLogger)
    implementation(Dependencies.koinCompose)
}

fun DependencyHandler.compose() {
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeUiToolingPreview)
    implementation(Dependencies.composeMaterial3)
    implementation(Dependencies.composeActivity)
    debugImplementation(Dependencies.composeUiTooling)
    debugImplementation(Dependencies.composeUiTestManifest)
}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.retrofit)
    implementation(Dependencies.converterGson)
    implementation(Dependencies.okhttp)
    implementation(Dependencies.loggingInterceptor)
}
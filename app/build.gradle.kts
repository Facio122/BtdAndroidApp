plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.example.btdapplication"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.btdapplication"
        minSdk = 30
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }



    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

val koinVersion = "3.5.3"
val koinAnnotationsVersion = "1.2.0"
val retrofitVersion = "2.11.0"
val gsonVersion = "2.11.0"
val okhttpVersion = "4.12.0"

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation("com.google.accompanist:accompanist-systemuicontroller:0.32.0")

    //compose
    implementation(platform("androidx.compose:compose-bom:2024.09.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.activity:activity-compose:1.9.0")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //koin
    implementation("io.insert-koin:koin-android:${koinVersion}")
    implementation("io.insert-koin:koin-core:${koinVersion}")
    implementation("io.insert-koin:koin-androidx-compose:${koinVersion}")
    implementation("io.insert-koin:koin-ktor:${koinVersion}")
    implementation("io.insert-koin:koin-logger-slf4j:${koinVersion}")
    implementation("io.insert-koin:koin-annotations:$koinAnnotationsVersion")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:${retrofitVersion}")
    implementation("com.squareup.retrofit2:converter-gson:${gsonVersion}")
    implementation("com.squareup.okhttp3:okhttp:${okhttpVersion}")
    implementation("com.squareup.okhttp3:logging-interceptor:${okhttpVersion}")
}
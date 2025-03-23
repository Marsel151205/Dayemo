plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.google.service)
}

android {
    namespace = "com.marsel.dayemo"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.marsel.dayemo"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    // Core
    implementation(libs.androidx.core.ktx)

    // Lifecycle Runtime
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Activity
    implementation(libs.androidx.activity.compose)

    // Compose Bom
    implementation(platform(libs.androidx.compose.bom))

    // UI
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)

    // Preview
    implementation(libs.androidx.ui.tooling.preview)

    // Material
    implementation(libs.androidx.material3)
    implementation(libs.androidx.constraintlayout)

    // Tests
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // Tooling
    debugImplementation(libs.androidx.ui.tooling)

    // Manifest
    debugImplementation(libs.androidx.ui.test.manifest)

    // Navigation Component
    implementation(libs.navigation.compose)

    // Firebase BoM
    implementation(platform(libs.firebase.bom))

    // Firebase Analytics
    implementation(libs.firebase.analytics)
}
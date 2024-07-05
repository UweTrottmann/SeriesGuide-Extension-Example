plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android") // Apply to unify versions in dependencies
}

android {
    namespace = "com.uwetrottmann.seriesguide.extensionexample.app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.uwetrottmann.seriesguide.extensionexample.app"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"))
        }
    }
}

dependencies {
    // https://developer.android.com/jetpack/androidx/releases/appcompat
    // When updating, also update Kotlin plugin to match to align version in transitive dependencies
    implementation("androidx.appcompat:appcompat:1.7.0")

    implementation("com.uwetrottmann.seriesguide:seriesguide-api:2.2.1")
}

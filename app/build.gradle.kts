plugins {
    id("com.android.application")
}

android {
    namespace = "com.uwetrottmann.seriesguide.extensionexample.app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.uwetrottmann.seriesguide.extensionexample.app"
        minSdk = 21
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
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
    implementation("androidx.appcompat:appcompat:1.7.0")

    implementation("com.uwetrottmann.seriesguide:seriesguide-api:2.2.1")
}

apply plugin: 'com.android.application'

android {
    namespace 'com.uwetrottmann.seriesguide.extensionexample.app'
    compileSdkVersion 34

    defaultConfig {
        minSdkVersion 21
        targetSdkVersion 30
        versionCode 1
        versionName "1.0"
    }

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFile getDefaultProguardFile('proguard-android.txt')
        }
    }
}

dependencies {
    // https://developer.android.com/jetpack/androidx/releases/appcompat
    implementation 'androidx.appcompat:appcompat:1.7.0'

    implementation 'com.uwetrottmann.seriesguide:seriesguide-api:2.2.1'
}

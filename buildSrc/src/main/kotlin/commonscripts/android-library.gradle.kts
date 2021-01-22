package commonscripts


plugins {
    `android-library` apply false
    `kotlin-android` apply false
    `kotlin-parcelize` apply false
    id("com.vanniktech.android.junit.jacoco")
}

android {
    compileSdkVersion(Config.compileSdk)

    defaultConfig {
        minSdkVersion(Config.minSdk)
        targetSdkVersion(Config.targetSdk)
    }

    buildTypes {
        buildTypes {
            getByName(BuildTypes.DEBUG) {
                isMinifyEnabled = false
                isDebuggable = true
            }
            getByName(BuildTypes.RELEASE) {
                isMinifyEnabled = true
            }
        }
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}

dependencies {
    implementation(Libs.kotlin_stdlib)
}

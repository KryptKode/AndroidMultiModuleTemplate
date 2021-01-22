plugins {
    androidLibrary
    kotlinKapt
}

android {

    defaultConfig {
        kapt {
            arguments {
                arg("room.schemaLocation", "$projectDir/schemas")
            }
        }
    }

    sourceSets {
        getByName("androidTest").assets.srcDirs("$projectDir/schemas")
    }
}

dependencies {

    implementation(Libs.kotlinx_coroutines_android)
    implementation(Libs.work_runtime_ktx)
    androidTestImplementation(Libs.work_testing)

    implementation(Libs.hilt_android)
    kapt(Libs.hilt_android_compiler)
    implementation(Libs.hilt_work)
    kapt(Libs.hilt_compiler)

    implementation(Libs.moshi_kotlin)

    implementation(Libs.room_ktx)
    implementation(Libs.room_runtime)
    kapt(Libs.room_compiler)

    implementation(Libs.okhttp)
    implementation(Libs.logging_interceptor)

    implementation(Libs.retrofit)
    implementation(Libs.converter_moshi)
    implementation(Libs.moshi_kotlin)
    kapt(Libs.moshi_kotlin_codegen)

    androidTestImplementation(Libs.androidx_test_ext_junit)
    androidTestImplementation(Libs.espresso_core)

    testImplementation(project(BuildModules.Commons.testShared))
    testImplementation(Libs.mockwebserver)
}

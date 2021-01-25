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

        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
    }

    sourceSets {
        getByName("androidTest").assets.srcDirs("$projectDir/schemas")
    }

    packagingOptions {
        exclude("**/attach_hotspot_windows.dll")
        exclude("META-INF/licenses/**")
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
    }
}

dependencies {

    implementation(project(BuildModules.Common.androidShared))

    implementation(Libs.kotlinx_coroutines_android)
    implementation(Libs.work_runtime_ktx)
    androidTestImplementation(Libs.work_testing)

    implementation(Libs.hilt_android)
    kapt(Libs.hilt_android_compiler)
    implementation(Libs.hilt_work)
    kapt(Libs.hilt_compiler)

    implementation(Libs.timber)
    implementation(Libs.moshi_kotlin)

    implementation(Libs.room_ktx)
    implementation(Libs.room_runtime)
    kapt(Libs.room_compiler)

    implementation(Libs.paging_runtime_ktx)

    implementation(Libs.glide)
    kapt(Libs.com_github_bumptech_glide_compiler)

    implementation(Libs.swiperefreshlayout)

    implementation(Libs.okhttp)
    implementation(Libs.logging_interceptor)

    implementation(Libs.retrofit)
    implementation(Libs.converter_moshi)
    implementation(Libs.moshi_kotlin)
    kapt(Libs.moshi_kotlin_codegen)

    implementation(Libs.espresso_idling_resource)

    androidTestImplementation(Libs.androidx_test_ext_junit)
    androidTestImplementation(Libs.espresso_core)
    androidTestImplementation(Libs.kotlin_test_junit)
    androidTestImplementation(Libs.kotlinx_coroutines_test) {
        exclude(group = "org.jetbrains.kotlinx", module = "kotlinx-coroutines-debug")
    }
    androidTestImplementation(Libs.androidx_test_runner)
    androidTestImplementation(Libs.core_testing)
    androidTestImplementation(Libs.espresso_contrib)
    androidTestImplementation(Libs.espresso_intents)

    androidTestImplementation(Libs.androidx_test_rules)

    androidTestImplementation(Libs.androidx_test_ext_junit)
    androidTestImplementation(Libs.mockk_android)
    androidTestImplementation(Libs.room_testing)

    androidTestImplementation(Libs.truth)
    androidTestImplementation(project(BuildModules.Common.testShared))

    testImplementation(project(BuildModules.Common.testShared))
    testImplementation(Libs.mockwebserver)
    testImplementation(Libs.paging_common)
    testImplementation(Libs.robolectric)
    testImplementation(Libs.androidx_test_rules)
    testImplementation("androidx.test:core:1.3.0")
}

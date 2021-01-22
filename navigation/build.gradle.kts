plugins {
    androidLibrary
}

dependencies {
    implementation(project(BuildModules.Commons.androidShared))

    implementation(Libs.kotlinx_coroutines_android)
    implementation(Libs.kotlinx_coroutines_core)

    implementation(Libs.timber)
    implementation(Libs.core_ktx)
    implementation(Libs.appcompat)

    implementation(Libs.material)
    implementation(Libs.constraintlayout)

    implementation(Libs.fragment_ktx)

    implementation(Libs.lifecycle_viewmodel_ktx)
    implementation(Libs.lifecycle_common_java8)

    implementation("com.github.florent37:inline-activity-result-kotlin:1.0.4")
}

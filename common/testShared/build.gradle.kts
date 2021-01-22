plugins {
    id(ScriptsPlugins.kotlinLibrary)
}

dependencies {
    api(Libs.junit_junit)
    api(Libs.mockk)
    api(Libs.truth)
    api(Libs.kotlinx_coroutines_test)
}

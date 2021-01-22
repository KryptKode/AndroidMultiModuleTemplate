package commonscripts

plugins {
    kotlin apply false
    id("com.vanniktech.android.junit.jacoco") apply false
}

dependencies {
    implementation(Libs.kotlin_stdlib)
}
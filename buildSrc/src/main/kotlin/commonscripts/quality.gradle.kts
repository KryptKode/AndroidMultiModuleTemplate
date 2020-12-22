package commonscripts

import io.gitlab.arturbosch.detekt.Detekt

plugins {
    id("io.gitlab.arturbosch.detekt")
    id ("org.jlleitschuh.gradle.ktlint")
}

val detektAll by tasks.registering(Detekt::class) {
    group = "Quality"
    description = "Runs a detekt code analysis on the Android codebase."
    parallel = true
    buildUponDefaultConfig = true

    val outputFile = "${project.buildDir}/staticAnalysis/index.html"

    setSource(files(rootProject.projectDir))
    config.setFrom("${project.rootDir}/config/detekt/detekt.yml")

    include("**/*.kt")
    exclude("**/*.kts", "*/build/*", "/buildSrc")

    reports {
        html.enabled = true
        html.destination = file(outputFile)
        xml.enabled = false
        txt.enabled = false
    }

    val reportFile = "Static Analysis Report: $outputFile \n"
    doFirst { println(reportFile) }
    doLast { println(reportFile) }
}

tasks.register("runStaticAnalysis") {
    description = "Run static analysis on the Android codebase."
    dependsOn(detektAll)
}

ktlint {
    android.set(true)
}
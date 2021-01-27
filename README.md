[![Actions Status](https://github.com/KryptKode/AndroidMultiModuleTemplate/workflows/android/badge.svg)](https://github.com/KryptKode/AndroidMultiModuleTemplate/actions)
[![codecov](https://codecov.io/gh/KryptKode/AndroidMultiModuleTemplate/branch/master/graph/badge.svg?token=3L2WH4293M)](https://codecov.io/gh/KryptKode/AndroidMultiModuleTemplate)
[![Kotlin Version](https://img.shields.io/badge/kotlin-1.4.21-blue.svg)](http://kotlinlang.org/)
[![AGP](https://img.shields.io/badge/AGP-4.1.0-blue)](https://developer.android.com/studio/releases/gradle-plugin)
[![Gradle](https://img.shields.io/badge/Gradle-6.5-blue)](https://gradle.org)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0)

# Android Multi-Module Template

A template for bootstrapping a multi-module android project. It demonstrates clean architecture and has a navigation module based on [this](https://github.com/PhilippeBoisney/android-multi-modules-navigation-demo)

## Top things to learn here

- Multi-module [clean architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
- Kotlin coroutines with [Flow]()
- Dependency injection with [Dagger-Hilt](https://dagger.dev/hilt/)
- View abstracted from Fragment like [componentizationArch](https://github.com/julianomoraes/componentizationArch)
- API request with [Retrofit](http://square.github.io/retrofit) and [Moshi](https://github.com/square/moshi) for JSON serialisation and deserialization
- Local persistence with [Room](https://developer.android.com/topic/libraries/architecture/room)
- Paging with [Paging 3.0](https://developer.android.com/topic/libraries/architecture/paging/v3-overview)
- CI  with [Github actions](https://github.com/features/actions)
- Code coverage with [jacoco](https://github.com/vanniktech/gradle-android-junit-jacoco-plugin) with reports uploaded to [codecov](https://codecov.io/gh/KryptKode/DroidArch/)
- Code lint check with [Ktlint](https://github.com/pinterest/ktlint) using a [gradle plugin](https://github.com/JLLeitschuh/ktlint-gradle)
- Static code analysis with [detekt](https://github.com/detekt/detekt)
- Dependency management with [buildSrc](https://gradle.org/kotlin/)  (Kotlin DSL)
- Dependency updates with [buildSrcVersions](https://jmfayard.github.io/refreshVersions/)
- [Git hooks](https://github.com/KryptKode/DroidArch/tree/master/scripts/git-hooks) to perform ktlint, detekt and lint checks before committing

## Libraries

- [Material Components](https://github.com/material-components/material-components-android/)
- [Constraint Layout](https://developer.android.com/reference/android/support/constraint/ConstraintLayout)
- [Retrofit](http://square.github.io/retrofit) for REST api communication
- [Moshi](https://github.com/square/moshi) for JSON serialisation and deserialization
- [Mockk](https://github.com/mockk/mockk) for mocking in tests
- [Dagger-Hilt](https://dagger.dev/hilt/) for dependency injection
- [Kotlin Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html) for concurrency
- [Turbine](https://github.com/cashapp/turbine) for testing flow
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) & [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
- [Navigation Architecture Component](https://developer.android.com/guide/navigation/navigation-getting-started)
- [Room](https://developer.android.com/topic/libraries/architecture/room) for database
- [Glide](https://github.com/bumptech/glide) for image loading
- [ViewBinding](https://developer.android.com/topic/libraries/view-binding)
- [Kotlin Delegates](https://kotlinlang.org/docs/reference/delegated-properties.html)
- [Ktlint gradle plugin](https://github.com/JLLeitschuh/ktlint-gradle) for code lint checks
- [Detekt](https://github.com/detekt/detekt) for static code analysis
- [LeakCanary](https://github.com/square/leakcanary) for detecting memory leaks in development


### Extras

The gradle script uses Kotlin Gradle DSL ([buildSrc](https://gradle.org/kotlin/) ) which brings Kotlin's rich language features to gradle configuration. The project also uses detekt to detect code smells and ktlint to enforce proper code style. Github actions handles continuous integration, and runs detekt, ktlint, lint and unit tests concurrently.  A pre-commit git hook  verifies the project's code style before committing code.  Test coverage reports are uploaded to [codecov]().

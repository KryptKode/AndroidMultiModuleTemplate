# Android Multi-Module Template

A template for bootstrapping a multi-module android project. It demonstrates clean architecture and has a navigation module based on [this](https://github.com/PhilippeBoisney/android-multi-modules-navigation-demo)

## Top things to learn here

- Multi-module clean architecture
- Kotlin coroutines with Flow
- Dependency injection with Dagger-Hilt
- Unit testing
- View abstracted from Fragment
- API request with Retrofit
- CI/CD with Github actions
- Code lint check with [Ktlint](https://github.com/pinterest/ktlint) using a [gradle plugin](https://github.com/JLLeitschuh/ktlint-gradle)
- Static code analysis with [detekt](https://github.com/detekt/detekt)
- Dependency management with [buildSrc](https://gradle.org/kotlin/)  (Kotlin DSL)
- Dependency updates with [buildSrcVersions](https://jmfayard.github.io/refreshVersions/)

## Libraries

- [Material Components](https://github.com/material-components/material-components-android/)
- [Constraint Layout](https://developer.android.com/reference/android/support/constraint/ConstraintLayout)
- [Retrofit](http://square.github.io/retrofit) for REST api communication
- [Mockk](https://github.com/mockk/mockk) for mocking in tests
- [Dagger2](https://github.com/google/dagger) for dependency injection
- [Kotlin Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html) for concurrency
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) & [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
- [Navigation Architecture Component](https://developer.android.com/guide/navigation/navigation-getting-started)
- [ViewBinding](https://developer.android.com/topic/libraries/view-binding)
- [Kotlin Delegates](https://kotlinlang.org/docs/reference/delegated-properties.html)
- [Ktlint gradle plugin](https://github.com/JLLeitschuh/ktlint-gradle) for code lint checks
- [Detekt](https://github.com/detekt/detekt) for static code analysis

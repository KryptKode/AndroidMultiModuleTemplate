package com.kryptkode.navigation.model

import com.kryptkode.navigation.direction.NavDirection
import kotlin.coroutines.Continuation

/**
 * A simple sealed class to handle more properly
 * navigation from a [androidx.lifecycle.ViewModel]
 */
sealed class NavigationCommand {

    data class ForResult(
        val direction: NavDirection,
        val continuation: Continuation<NavigationResult>
    ) : NavigationCommand()

    data class To(val direction: NavDirection) : NavigationCommand()
    data class ToPrevious(val direction: NavDirection) : NavigationCommand()
    object Back : NavigationCommand()
    data class Finish(val results: Any?) : NavigationCommand()
}

package com.kryptkode.navigation.direction

import android.app.Activity
import androidx.fragment.app.Fragment
import com.kryptkode.navigation.ktx.EmptyNavContext

typealias Screen = Any

/**
 * Base interface representing a "direction" to go.
 */
interface NavDirection

/**
 * Direction representing a screen.
 *
 * Used in the case we want to navigate to an other screen of the application.
 */
interface ScreenDirection : NavDirection {

    /**
     * Context for the screen direction.
     */
    val navContext: NavDirectionContext
        get() = EmptyNavContext

    /**
     * Screen to navigate to.
     *
     * It could be an [Activity] or a [Fragment] for example.
     */
    fun toScreen(): Screen
}

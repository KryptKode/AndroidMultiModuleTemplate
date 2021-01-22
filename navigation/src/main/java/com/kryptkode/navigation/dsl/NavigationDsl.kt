package com.kryptkode.navigation.dsl

import com.kryptkode.navigation.direction.NavDirection
import com.kryptkode.navigation.direction.ScreenDirection
import com.kryptkode.navigation.ktx.isFragment
import com.kryptkode.navigation.ktx.isFragmentDialog
import com.kryptkode.navigation.ktx.isIntent

internal typealias ScreenBlock = (ScreenDirection.() -> Unit)

/**
 * Executes the [block] in order to realize some specific actions from a [NavDirection].
 *
 * For example:
 * direction.doWhen {
 *   isFragment { // Do whatever }
 *   otherDirection { super.navigateTo(direction) }
 * }
 */
fun NavDirection.doWhen(
    block: (NavigationDsl.() -> OtherDirectionDsl)
) = block(NavigationDsl(this))

/**
 * Direction mostly used to represent the end of the DSL
 * (and enforce the usage of the [otherDirection{}] DSL.
 */
object OtherDirectionDsl

/**
 *  Convenient class used to properly format our doWhen { } DSL.
 */
class NavigationDsl(
    private val direction: NavDirection
) {

    // region Data

    private var isFragmentDialog: ScreenBlock? = null
    private var isFragment: ScreenBlock? = null
    private var isIntent: ScreenBlock? = null
    private lateinit var otherDirection: () -> Unit

    // endregion

    // region Dsl

    fun isFragmentDialog(block: ScreenBlock) = this.apply { isFragmentDialog = block }
    fun isFragment(block: ScreenBlock) = this.apply { isFragment = block }
    fun isIntent(block: ScreenBlock) = this.apply { isIntent = block }
    fun otherDirection(block: () -> Unit) = this.apply { otherDirection = block }
        .run { build() }
        .let { OtherDirectionDsl }

    // endregion

    // region DSL builder

    private fun build() {
        when {
            direction.isFragmentDialog() -> {
                isFragmentDialog?.invoke(direction as ScreenDirection) ?: otherDirection()
            }
            direction.isFragment() -> {
                isFragment?.invoke(direction as ScreenDirection) ?: otherDirection()
            }
            direction.isIntent() -> {
                isIntent?.invoke(direction as ScreenDirection) ?: otherDirection()
            }

            else -> otherDirection()
        }
    }

    // endregion
}

package com.kryptkode.navigation.model

import android.app.Activity
import android.content.Intent
import android.os.Parcelable
import androidx.fragment.app.FragmentActivity
import com.kryptkode.commonandroid.extension.illegal
import kotlinx.parcelize.Parcelize

/**
 * Result returned by a [FragmentActivity] launched with [com.kryptkode.navigation.Navigable.navigateToForResult].
 *
 * @property [code]: the [FragmentActivity] result code, like [Activity.RESULT_OK] for example.
 * @property [data]: the possible data returned by the [FragmentActivity]
 */
data class NavigationResult(
    val code: Int,
    val data: Intent?
) {

    fun <T : Parcelable> getParcelable(): T =
        requireNotNull(data)
            .getParcelableArrayListExtra<T>(RESULT_PARAM)
            ?.toList()
            ?.first()
            ?: illegal("The data doesn't contain any extra.")

    fun <T : Parcelable> getParcelables(): List<T> =
        requireNotNull(data)
            .getParcelableArrayListExtra<T>(RESULT_PARAM)
            ?.toList()
            ?: illegal("The data doesn't contain any extra.")

    val hasBeenCanceled: Boolean
        get() = code == Activity.RESULT_CANCELED

    val hasData: Boolean
        get() = code == Activity.RESULT_OK

    @Parcelize
    internal object SuccessWithNoResult : Parcelable

    companion object {
        internal const val RESULT_PARAM = "RESULT_PARAM"
    }
}

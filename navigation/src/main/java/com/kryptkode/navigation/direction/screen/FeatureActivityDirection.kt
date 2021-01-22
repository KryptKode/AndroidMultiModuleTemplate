package com.kryptkode.navigation.direction.screen

import android.os.Parcelable
import com.kryptkode.navigation.direction.ScreenDirection
import kotlinx.parcelize.Parcelize

interface FeatureActivityDirection : ScreenDirection {

    @Parcelize
    data class Params(
        val id: String,
        val enableFinishForResult: Boolean = false
    ) : Parcelable

    @Parcelize
    data class Returns(
        val message: String
    ) : Parcelable
}

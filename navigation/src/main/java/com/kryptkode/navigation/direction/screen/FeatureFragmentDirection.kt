package com.kryptkode.navigation.direction.screen

import android.os.Parcelable
import com.kryptkode.navigation.direction.ScreenDirection
import kotlinx.parcelize.Parcelize

interface FeatureFragmentDirection : ScreenDirection {
    @Parcelize
    data class Params(
        val id: String
    ) : Parcelable
}

package org.android.wantedhackathon.review.entity

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class TagInfoEntity(
    val tag: String,
    @DrawableRes val image: Int,
    @StringRes val description: Int
)

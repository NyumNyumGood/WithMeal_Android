package org.android.wantedhackathon.review

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class TagInfoEntity(
    val tag: String,
    @DrawableRes val image: Int,
    @StringRes val description: Int
)

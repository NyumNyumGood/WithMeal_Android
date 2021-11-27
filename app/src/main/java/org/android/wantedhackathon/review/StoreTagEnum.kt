package org.android.wantedhackathon.review

import org.android.wantedhackathon.R

enum class StoreTagEnum(val tag: String, val image: Int, val description: Int) {
    TASTE("맛", R.drawable.taste_grp, R.string.taste_grp),
    KINDNESS("친절", R.drawable.kind_grp, R.string.kind_grp),
    CHEAP("가성비", R.drawable.money_grp, R.string.money_grp),
    CLEAN("청결", R.drawable.clean_grp, R.string.clean_grp),
    MOOD("분위기", R.drawable.mood_grp, R.string.mood_grp)
}
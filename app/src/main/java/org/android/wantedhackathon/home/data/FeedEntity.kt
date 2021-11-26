package org.android.wantedhackathon.home.data


data class FeedEntity(
    val restaurantName: String?,
    val restaurantCategory: String?,
    val currentDate: String,
    val profile: Int,
    val nickname: String,
    val keyword: List<TagEntity>,
    val representativePhoto: Int,
    val friends: String,
    val prefers: Int,
    val review: Int
)
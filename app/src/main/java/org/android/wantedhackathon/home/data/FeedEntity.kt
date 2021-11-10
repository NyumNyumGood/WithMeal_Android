package org.android.wantedhackathon.home.data

data class FeedEntity(
    val restaurantName : String,
    val restaurantCategory : String,
    val bookmark : Int,
    val profile : Int,
    val nickname : String,
    val currentDate : String,
    val keyword : List<Int>,
    val representativePhoto : Int,
    val friends : String,
    val prefers : Int,
    val review : String
)
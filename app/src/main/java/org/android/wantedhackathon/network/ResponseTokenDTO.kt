package org.android.wantedhackathon.network


import com.google.gson.annotations.SerializedName

data class ResponseTokenDTO(
    @SerializedName("data")
    val data: Data,
    val message: String,
    val status: Int
){
    data class Data(
        val accessToken: String,
        val accessTokenExpiredAt: String
    )
}
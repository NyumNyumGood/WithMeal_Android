package org.android.wantedhackathon.network

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("/api/v1/token")
    fun getJWTToken() : Single<ResponseTokenDTO>
}
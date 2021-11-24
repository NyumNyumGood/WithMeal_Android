package org.android.wantedhackathon.network

import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import javax.inject.Inject

class TokenControllerImpl @Inject constructor(
    val retrofitInterface: RetrofitInterface
) : TokenController{
    override fun fetchAccessToken(): Single<ResponseTokenDTO> =
        retrofitInterface.getJWTToken()

}
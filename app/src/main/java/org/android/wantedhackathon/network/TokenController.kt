package org.android.wantedhackathon.network

import io.reactivex.rxjava3.core.Single

interface TokenController {
    fun fetchAccessToken(): Single<ResponseTokenDTO>
}
package org.android.wantedhackathon.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.android.wantedhackathon.network.RetrofitInterface
import org.android.wantedhackathon.network.TokenController
import org.android.wantedhackathon.network.TokenControllerImpl
import org.android.wantedhackathon.qualifier.UnAuthRetrofitService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ControllerModule {
    @Provides
    @Singleton
    fun provideTokenController(@UnAuthRetrofitService retrofitInterface: RetrofitInterface) : TokenController =
        TokenControllerImpl(retrofitInterface)
}
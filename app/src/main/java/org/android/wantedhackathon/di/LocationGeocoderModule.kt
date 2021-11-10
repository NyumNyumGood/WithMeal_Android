package org.android.wantedhackathon.di

import android.content.Context
import android.location.Geocoder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.android.wantedhackathon.util.AddressExtractor
import java.util.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocationGeocoderModule {
    @Provides
    @Singleton
    fun provideGeocoder(@ApplicationContext context: Context): Geocoder = Geocoder(context, Locale.KOREA)

    @Provides
    @Singleton
    fun provideAddressExtractor(geocoder: Geocoder): AddressExtractor = AddressExtractor(geocoder)


}
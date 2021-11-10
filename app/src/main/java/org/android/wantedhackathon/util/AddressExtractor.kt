package org.android.wantedhackathon.util

import android.location.Geocoder
import android.location.Location
import org.android.wantedhackathon.home.data.LocationEntity
import javax.inject.Inject

class AddressExtractor @Inject constructor(
    private val geocoder: Geocoder
){
    fun reverseGeocoding(latitude: Double, longitude: Double): Pair<String,String> {
        val address = geocoder.getFromLocation(latitude, longitude, 10)[0]
        return address.adminArea to address.thoroughfare
    }

    fun extractAddress(location: Location?): LocationEntity {
        val address = location?.let { reverseGeocoding(location.latitude, location.longitude) }
        val cityName = address?.first?.substring(0,2)
        val adminArea = if (address != null && cityName == SEOUL) address.first.substring(0,2) + CITY else CAN_NOT_FOUND_LOCATION
        val thoroughfare = if (address?.second != null && cityName == SEOUL) address.second else ""
        return LocationEntity(location?.latitude, location?.longitude, adminArea, thoroughfare)
    }

    companion object {
        private const val CITY = "시"
        private const val CAN_NOT_FOUND_LOCATION = "서울시청"
        private const val SEOUL = "서울"
    }
}
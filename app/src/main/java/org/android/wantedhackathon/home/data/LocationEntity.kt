package org.android.wantedhackathon.home.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LocationEntity(
    val latitude: Double?,
    val longitude: Double?,
    val adminArea: String?,
    val thoroughfare: String?
): Parcelable
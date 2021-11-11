package org.android.wantedhackathon.home.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.location.FusedLocationProviderClient
import dagger.hilt.android.lifecycle.HiltViewModel
import org.android.wantedhackathon.R
import org.android.wantedhackathon.base.DisposableViewModel
import org.android.wantedhackathon.home.data.FeedEntity
import org.android.wantedhackathon.home.data.FollowingEntity
import org.android.wantedhackathon.home.data.LocationEntity
import org.android.wantedhackathon.util.AddressExtractor
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fusedLocationProviderClient: FusedLocationProviderClient,
    private val addressExtractor: AddressExtractor) :
    DisposableViewModel() {
    private val _currentLocation = MutableLiveData<LocationEntity>()
    val currentLocation: LiveData<LocationEntity>
        get() = _currentLocation

    private val _currentAddress = MutableLiveData<String>()
    val currentAddress: LiveData<String>
        get() = _currentAddress

    private val _followingUserList = MutableLiveData<List<FollowingEntity>>()
    val followingUserList : LiveData<List<FollowingEntity>>
        get() = _followingUserList

    private val _feedReviewList = MutableLiveData<List<FeedEntity>>()
    val feedReviewList : LiveData<List<FeedEntity>>
        get() = _feedReviewList

    init{
        fetchCurrentLocation()
        fetchFollowingUserList()
        fetchFeedReviewList()
    }

    @SuppressLint("MissingPermission")
    fun fetchCurrentLocation() {
        fusedLocationProviderClient.lastLocation
            .addOnSuccessListener { location ->
                val address = addressExtractor.extractAddress(location)
                _currentAddress.value = "${address.adminArea} ${address.thoroughfare}"
                _currentLocation.value = address
            }
    }

    private fun fetchFollowingUserList(){
        val followingUserList = listOf(
            FollowingEntity(
                R.drawable.ic_activatebtn,
                R.drawable.profile_img,
                R.string.following_nickname
            ),
            FollowingEntity(
                R.drawable.ic_activatebtn,
                R.drawable.profile_img2,
                R.string.following_nickname2
            ),
            FollowingEntity(
                R.drawable.ic_activatebtn,
                R.drawable.profile_img3,
                R.string.following_nickname3
            ),
            FollowingEntity(
                null,
                R.drawable.profile_img4,
                R.string.following_nickname4
            ),
            FollowingEntity(
                null,
                R.drawable.profile_img5,
                R.string.following_nickname5
            ),
            FollowingEntity(
                null,
                R.drawable.profile_img,
                R.string.following_nickname6
            )
        )
        _followingUserList.value = followingUserList
    }

    private fun fetchFeedReviewList(){
        val feedReviewList = listOf(
            FeedEntity(
                "멕시코즈",
                "한식",
                "10월 21일",
                R.drawable.profile_img4,
                "규니",
                "가성비",
                R.drawable.food_img,
                "with 박박디라라,김징",
                23,
                R.string.review_content
            ),
            FeedEntity(
                "멕시코즈",
                "한식",
                "10월 21일",
                R.drawable.profile_img4,
                "규니",
                "가성비",
                R.drawable.food_img,
                "with 박박디라라,김징",
                23,
                R.string.review_content
            )
        )
        _feedReviewList.value = feedReviewList
    }


}
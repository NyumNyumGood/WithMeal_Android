package org.android.wantedhackathon.home.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.location.FusedLocationProviderClient
import dagger.hilt.android.lifecycle.HiltViewModel
import org.android.wantedhackathon.R
import org.android.wantedhackathon.base.DisposableViewModel
import org.android.wantedhackathon.home.data.*
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

    private val _hotReviewList = MutableLiveData<List<HotContentEntity>>()
    val hotReviewList : LiveData<List<HotContentEntity>>
        get() = _hotReviewList

    private val _newReviewList = MutableLiveData<List<NewContentEntity>>()
    val newReviewList : LiveData<List<NewContentEntity>>
        get() = _newReviewList

    private val _tagOption = MutableLiveData<List<TagEntity>>()
    val tagOption : LiveData<List<TagEntity>>
        get() = _tagOption

    init{
        fetchCurrentLocation()
        fetchFollowingUserList()
        fetchFeedReviewList()
        fetchHotReviewList()
        fetchNewReviewList()
        loadTagList()
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
                listOf(
                    TagEntity(
                        R.drawable.money_grp,
                        "가성비"
                    ),
                    TagEntity(
                        R.drawable.clean_grp,
                        "청결"
                    ),
                    TagEntity(
                        R.drawable.kind_grp,
                        "친절"
                    )
                ),
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
                listOf(
                    TagEntity(
                        R.drawable.mood_grp,
                        "분위기"
                    ),
                    TagEntity(
                        R.drawable.taste_grp,
                        "청결"
                    )
                ),
                R.drawable.food_img,
                "with 박박디라라,김징",
                23,
                R.string.review_content
            )
        )
        _feedReviewList.value = feedReviewList
    }

    private fun fetchHotReviewList(){
        val hotReviewList = listOf(
            HotContentEntity(
                R.drawable.rank1,
                "퀴헨",
                "한식",
                2
            ),
            HotContentEntity(
                R.drawable.rank2,
                "퀴헨",
                "한식",
                2
            ),
            HotContentEntity(
                R.drawable.rank3,
                "퀴헨",
                "한식",
                2
            ),
            HotContentEntity(
                R.drawable.rank4,
                "퀴헨",
                "한식",
                2
            ),
            HotContentEntity(
                R.drawable.rank5,
                "퀴헨",
                "한식",
                2
            ),
            HotContentEntity(
                R.drawable.rank6,
                "퀴헨",
                "한식",
                2
            ),
            HotContentEntity(
                R.drawable.rank7,
                "퀴헨",
                "한식",
                2
            ),
            HotContentEntity(
                R.drawable.rank8,
                "퀴헨",
                "한식",
                2
            ),
            HotContentEntity(
                R.drawable.rank9,
                "퀴헨",
                "한식",
                2
            ),
            HotContentEntity(
                R.drawable.rank10,
                "퀴헨",
                "한식",
                2
            )
        )
        _hotReviewList.value = hotReviewList
    }
    private fun fetchNewReviewList() {
        val newReviewList = listOf(
            NewContentEntity(
                R.drawable.updatedphoto,
                "세겹먹는날",
                "한식",
                "갓성비가 내려와~ 적절한 금액대예요"
            ),
            NewContentEntity(
                R.drawable.updatedphoto,
                "솔직하다",
                "일식",
                "갓성비가 내려와~ 적절한 금액대예요"
            ),
            NewContentEntity(
                R.drawable.updatedphoto,
                "세겹먹는날",
                "한식",
                "갓성비가 내려와~ 적절한 금액대예요"
            ),
            NewContentEntity(
                R.drawable.updatedphoto,
                "쿠마",
                "일식",
                "갓성비가 내려와~ 적절한 금액대예요"
            )
        )
        _newReviewList.value = newReviewList
    }

    private fun loadTagList(){
        val tagOption = listOf(
            TagEntity(
                R.drawable.money_grp,
                "가성비"
            ),
            TagEntity(
                R.drawable.clean_grp,
                "청결"
            ),
            TagEntity(
                R.drawable.kind_grp,
                "친절"
            )
        )
        _tagOption.value = tagOption
    }

}
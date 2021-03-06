package org.android.wantedhackathon.home.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.location.FusedLocationProviderClient
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import org.android.wantedhackathon.R
import org.android.wantedhackathon.base.DisposableViewModel
import org.android.wantedhackathon.home.data.*
import org.android.wantedhackathon.network.TokenController
import org.android.wantedhackathon.util.AddressExtractor
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val tokenController: TokenController,
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
        fetchRestaurantReviewList()
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
                R.drawable.dochi7,
                R.string.following_nickname6
            )
        )
        _followingUserList.value = followingUserList
    }

    private fun fetchFeedReviewList(){
        val feedReviewList = listOf(
            FeedEntity(
                "????????????",
                "??????",
                "10??? 21???",
                R.drawable.profile_img4,
                "??????",
                listOf(
                    TagEntity(
                        R.drawable.money_grp,
                        "?????????"
                    ),
                    TagEntity(
                        R.drawable.clean_grp,
                        "??????"
                    ),
                    TagEntity(
                        R.drawable.kind_grp,
                        "??????"
                    )
                ),
                R.drawable.food_img,
                "with ???????????????,??????",
                23,
                R.string.review_content2
            ),
            FeedEntity(
                "??????",
                "??????",
                "10??? 20???",
                R.drawable.profile_img,
                "???????????????",
                listOf(
                    TagEntity(
                        R.drawable.mood_grp,
                        "?????????"
                    ),
                    TagEntity(
                        R.drawable.taste_grp,
                        "???"
                    )
                ),
                R.drawable.feed_food2,
                "with ?????????,??????",
                16,
                R.string.review_content
            ),
            FeedEntity(
                "????????????",
                "??????",
                "10??? 20???",
                R.drawable.profile_img5,
                "?????????",
                listOf(
                    TagEntity(
                        R.drawable.money_grp,
                        "?????????"
                    ),
                    TagEntity(
                        R.drawable.kind_grp,
                        "??????"
                    )
                ),
                R.drawable.img05,
                "with ?????????,?????????",
                32,
                R.string.review_content3
            ),
            FeedEntity(
                "????????????",
                "??????",
                "10??? 18???",
                R.drawable.profile_img4,
                "??????",
                listOf(
                    TagEntity(
                        R.drawable.money_grp,
                        "?????????"
                    ),
                    TagEntity(
                        R.drawable.clean_grp,
                        "??????"
                    ),
                    TagEntity(
                        R.drawable.kind_grp,
                        "??????"
                    )
                ),
                R.drawable.img06,
                "with ?????????,????????????",
                11,
                R.string.review_content4
            )
        )
        _feedReviewList.value = feedReviewList
    }

    fun fetchRestaurantReviewList(){
        val feedReviewList = listOf(
            FeedEntity(
                null,
                null,
                "10??? 21???",
                R.drawable.profile_img4,
                "??????",
                listOf(
                    TagEntity(
                        R.drawable.money_grp,
                        "?????????"
                    ),
                    TagEntity(
                        R.drawable.clean_grp,
                        "??????"
                    ),
                    TagEntity(
                        R.drawable.kind_grp,
                        "??????"
                    )
                ),
                R.drawable.food_imgreview,
                "with ???????????????,??????",
                23,
                R.string.review_content2
            ),
            FeedEntity(
                null,
                null,
                "10??? 21???",
                R.drawable.mypage_profile,
                "???????????????",
                listOf(
                    TagEntity(
                        R.drawable.money_grp,
                        "?????????"
                    ),
                    TagEntity(
                        R.drawable.taste_grp,
                        "??????"
                    )
                ),
                R.drawable.food_imgreview2,
                "with ???????????????,??????",
                8,
                R.string.review_content
            )
        )
        _feedReviewList.value = feedReviewList
    }


    private fun fetchHotReviewList(){
        val hotReviewList = listOf(
            HotContentEntity(
                R.drawable.rank1,
                "??????",
                "??????",
                16
            ),
            HotContentEntity(
                R.drawable.rank2,
                "????????????",
                "??????",
                4
            ),
            HotContentEntity(
                R.drawable.rank3,
                "?????????",
                "?????????",
                1
            ),
            HotContentEntity(
                R.drawable.rank4,
                "???????????????",
                "??????/?????????",
                10
            ),
            HotContentEntity(
                R.drawable.rank5,
                "???????????????",
                "??????",
                2
            ),
            HotContentEntity(
                R.drawable.rank6,
                "????????????",
                "??????",
                5
            ),
            HotContentEntity(
                R.drawable.rank7,
                "????????????",
                "??????",
                1
            ),
            HotContentEntity(
                R.drawable.rank8,
                "??????",
                "??????",
                3
            ),
            HotContentEntity(
                R.drawable.group9,
                "?????????",
                "??????",
                7
            ),
            HotContentEntity(
                R.drawable.group10,
                "???????????????",
                "??????",
                2
            )
        )
        _hotReviewList.value = hotReviewList
    }
    private fun fetchNewReviewList() {
        val newReviewList = listOf(
            NewContentEntity(
                R.drawable.food_img1,
                "???????????????",
                "??????",
                "???????????? ?????????~ ????????? ???????????????",
                2
            ),
            NewContentEntity(
                R.drawable.food_img2,
                "????????????",
                "??????",
                "?????? ????????? ???????????? ????????? ??? ???!",
                8
            ),
            NewContentEntity(
                R.drawable.food_img3,
                "???????????????",
                "???????????????",
                "????????? ?????? ??????? ???????????? ?????????",
                4
            ),
            NewContentEntity(
                R.drawable.food_img4,
                "?????????",
                "??????",
                "?????????.. ?????? ?????? ?????? ????????????",
                2
            )
        )
        _newReviewList.value = newReviewList
    }

    private fun loadTagList(){
        val tagOption = listOf(
            TagEntity(
                R.drawable.money_grp,
                "?????????"
            ),
            TagEntity(
                R.drawable.clean_grp,
                "??????"
            ),
            TagEntity(
                R.drawable.kind_grp,
                "??????"
            )
        )
        _tagOption.value = tagOption
    }

    fun getToken(){
        addDisposable(
            tokenController.fetchAccessToken()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    response.data.accessToken

                },{
                    it.printStackTrace()
                })
        )
    }


}
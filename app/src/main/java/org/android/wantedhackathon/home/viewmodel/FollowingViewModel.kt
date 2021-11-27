package org.android.wantedhackathon.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import org.android.wantedhackathon.R
import org.android.wantedhackathon.base.DisposableViewModel
import org.android.wantedhackathon.home.data.AddFollowingEntity
import org.android.wantedhackathon.home.data.FeedEntity
import org.android.wantedhackathon.home.data.TagEntity
import javax.inject.Inject


@HiltViewModel
class FollowingViewModel @Inject constructor() : DisposableViewModel(){
    private val _followingDetailInfo = MutableLiveData<List<FeedEntity>>()
    val followingDetailInfo : LiveData<List<FeedEntity>>
        get() = _followingDetailInfo

    private val _addFollowing = MutableLiveData<List<AddFollowingEntity>>()
    val addFollowing : LiveData<List<AddFollowingEntity>>
        get() = _addFollowing

    init {
        fetchAddFollowingList()
    }

    fun fetchFeedReviewList(){
        val followingDetailInfo = listOf(
            FeedEntity(
                "멕시코즈",
                "한식",
                "10월 21일",
                R.drawable.profile_img,
                "밥밥디라라",
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
                "with 메거공,김징",
                23,
                R.string.review_content2
            ),
            FeedEntity(
                "퀴헨",
                "한식",
                "10월 20일",
                R.drawable.profile_img,
                "밥밥디라라",
                listOf(
                    TagEntity(
                        R.drawable.mood_grp,
                        "분위기"
                    ),
                    TagEntity(
                        R.drawable.taste_grp,
                        "맛"
                    )
                ),
                R.drawable.feed_food2,
                "with 박주쳐,행인",
                16,
                R.string.review_content
            )
        )
        _followingDetailInfo.value = followingDetailInfo
    }

    fun fetchAddFollowingList(){
        val addFollowing = listOf(
            AddFollowingEntity(
                R.drawable.follow1,
                "밥묵쟈",
                "밥밥디라라님 외 8명이 팔로우합니다.",
                R.drawable.follow,
                R.drawable.intersect1,
                R.drawable.intersect2,
                "솔직하다",
                "가원양꼬치",
                "덮밥",
                "양꼬치"
            ),
            AddFollowingEntity(
                R.drawable.follow2,
                "먹어보자",
                "규니님이 필로우합니다",
                R.drawable.following,
                R.drawable.intersect3,
                R.drawable.intersect4,
                "nevernever",
                "라라브레드",
                "와인",
                "카페,디저트"
            ),
            AddFollowingEntity(
                R.drawable.add3,
                "귤귤",
                "규니님외 2명이 필로우합니다",
                R.drawable.follow,
                R.drawable.intersect5,
                R.drawable.intersect6,
                "만스피자",
                "경성초밥",
                "패스트푸드",
                "일식"
            ),
            AddFollowingEntity(
                R.drawable.add4,
                "몽이",
                "규니님이 필로우합니다",
                R.drawable.follow,
                R.drawable.intersect7,
                R.drawable.intersect8,
                "연안식당",
                "먹자부대찌개",
                "해물,생선요리",
                "찌개,전골"
            )
        )
        _addFollowing.value = addFollowing
    }
}
package org.android.wantedhackathon.mypage.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import org.android.wantedhackathon.R
import org.android.wantedhackathon.base.DisposableViewModel
import org.android.wantedhackathon.home.data.NewContentEntity
import org.android.wantedhackathon.mypage.data.VisitedPlaceEntity
import org.android.wantedhackathon.mypage.data.WishPlaceEntity
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor() : DisposableViewModel(){
    private val _visitedPlaceList = MutableLiveData<List<VisitedPlaceEntity>>()
    val visitedPlaceList : LiveData<List<VisitedPlaceEntity>>
        get() = _visitedPlaceList

    private val _wishList = MutableLiveData<List<WishPlaceEntity>>()
    val wishList : LiveData<List<WishPlaceEntity>>
        get() = _wishList

    init{
        fetchVisitedPlaceList()
        fetchWishList()
    }

    private fun fetchVisitedPlaceList() {
        val visitedPlaceList = listOf(
            VisitedPlaceEntity(
                R.drawable.visitedfoodimg,
                "세겹먹는날",
                "10월 21일"
            ),
            VisitedPlaceEntity(
                R.drawable.visited2,
                "페페그라노",
                "10월 18일"
            ),
            VisitedPlaceEntity(
                R.drawable.visited3,
                "가원양꼬치",
                "10월 16일"
            ),
            VisitedPlaceEntity(
                R.drawable.visited4,
                "페페그라노",
                "10월 12일"
            ),
            VisitedPlaceEntity(
                R.drawable.visited5,
                "잔월",
                "10월 2일"
            ),
            VisitedPlaceEntity(
                R.drawable.visited6,
                "사잇길",
                "9월 28일"
            )
        )
        _visitedPlaceList.value = visitedPlaceList
    }

    private fun fetchWishList() {
        val wishList = listOf(
            WishPlaceEntity(
                R.drawable.food_img1,
                "세겹먹는날",
                "한식",
                "갓성비가 내려와~ 적절한 금액대예요",
                2
            ),
            WishPlaceEntity(
                R.drawable.food_img2,
                "솔직하다",
                "일식",
                "직원 분들의 친절함에 감동이 두 배!",
                8
            ),
            WishPlaceEntity(
                R.drawable.food_img3,
                "버거투버거",
                "패스트푸드",
                "여기가 사진 맛집? 분위기가 좋아요",
                4
            ),
            WishPlaceEntity(
                R.drawable.food_img4,
                "휴돈정",
                "일식",
                "말잇못.. 말을 잊지 못할 맛이에요",
                2
            )
        )
        _wishList.value = wishList
    }
}
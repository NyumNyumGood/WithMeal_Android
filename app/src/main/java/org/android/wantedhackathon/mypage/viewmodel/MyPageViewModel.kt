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
                "사잇길",
                "11월 17일"
            ),
            VisitedPlaceEntity(
                R.drawable.visited4,
                "잔월",
                "09월 15일"
            ),
            VisitedPlaceEntity(
                R.drawable.visitedfoodimg,
                "세겹먹는날",
                "10월 21일"
            ),
            VisitedPlaceEntity(
                R.drawable.visitedfoodimg,
                "세겹먹는날",
                "10월 21일"
            )
        )
        _visitedPlaceList.value = visitedPlaceList
    }

    private fun fetchWishList() {
        val wishList = listOf(
            WishPlaceEntity(
                R.drawable.updatedphoto,
                "세겹먹는날",
                "한식",
                "갓성비가 내려와~ 적절한 금액대예요"
            ),
            WishPlaceEntity(
                R.drawable.updatedphoto,
                "솔직하다",
                "일식",
                "갓성비가 내려와~ 적절한 금액대예요"
            ),
            WishPlaceEntity(
                R.drawable.updatedphoto,
                "세겹먹는날",
                "한식",
                "갓성비가 내려와~ 적절한 금액대예요"
            ),
            WishPlaceEntity(
                R.drawable.updatedphoto,
                "쿠마",
                "일식",
                "갓성비가 내려와~ 적절한 금액대예요"
            )
        )
        _wishList.value = wishList
    }
}
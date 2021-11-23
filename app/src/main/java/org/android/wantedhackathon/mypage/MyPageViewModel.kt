package org.android.wantedhackathon.mypage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import org.android.wantedhackathon.R
import org.android.wantedhackathon.base.DisposableViewModel
import org.android.wantedhackathon.home.data.NewContentEntity
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor() : DisposableViewModel(){
    private val _visitedPlaceList = MutableLiveData<List<VisitedPlaceEntity>>()
    val visitedPlaceList : LiveData<List<VisitedPlaceEntity>>
        get() = _visitedPlaceList

    init{
        fetchVisitedPlaceList()
    }

    private fun fetchVisitedPlaceList() {
        val visitedPlaceList = listOf(
            VisitedPlaceEntity(
                R.drawable.visitedfoodimg,
                "세겹먹는날",
                "10월 21일"
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
            ),
            VisitedPlaceEntity(
                R.drawable.visitedfoodimg,
                "세겹먹는날",
                "10월 21일"
            )
        )
        _visitedPlaceList.value = visitedPlaceList
    }
}
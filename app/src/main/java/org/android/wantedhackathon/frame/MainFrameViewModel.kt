package org.android.wantedhackathon.frame

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainFrameViewModel : ViewModel() {
    private val _pageIndex: MutableLiveData<Int> = MutableLiveData(0)
    val pageIndex: LiveData<Int>
        get() = _pageIndex

    fun changePageIdx(idx: Int) {
        if (pageIndex.value != idx) _pageIndex.value = idx
    }
}
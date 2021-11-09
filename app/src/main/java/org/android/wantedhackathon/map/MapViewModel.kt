package org.android.wantedhackathon.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import org.android.wantedhackathon.base.DisposableViewModel
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor() : DisposableViewModel() {
    private val _currentLocationMap = MutableLiveData<Boolean>()
    val currentLocationMap : LiveData<Boolean>
        get() = _currentLocationMap


}
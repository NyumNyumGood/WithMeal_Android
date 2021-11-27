package org.android.wantedhackathon.signup.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import org.android.wantedhackathon.base.DisposableViewModel
import org.android.wantedhackathon.signup.data.EntranceSpinnerModel
import org.android.wantedhackathon.signup.data.UniversitySpinnerModel
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor()
    : DisposableViewModel() {
    private val _isSelectedEntrance = MutableLiveData<EntranceSpinnerModel>()
    val isSelectedEntrance: LiveData<EntranceSpinnerModel>
        get() = _isSelectedEntrance

    private val _isSeletectedSchool = MutableLiveData<UniversitySpinnerModel>()
    val isSelectedSchool : LiveData<UniversitySpinnerModel>
        get() = _isSeletectedSchool

    private val _schoolIdx = MutableLiveData<Int>()
    val schoolIdx: LiveData<Int>
        get() = _schoolIdx

    fun changeSchoolIdx(idx: Int) {
        _schoolIdx.value = idx
    }

}
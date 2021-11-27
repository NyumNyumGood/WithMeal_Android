package org.android.wantedhackathon.review.viewmodel

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import org.android.wantedhackathon.base.DisposableViewModel
import org.android.wantedhackathon.review.entity.TagInfoEntity
import javax.inject.Inject

@HiltViewModel
class ReviewViewModel @Inject constructor() : DisposableViewModel() {
    private val _uploadPictures = MutableLiveData<List<Uri>>()
    val uploadPictures: LiveData<List<Uri>>
        get() = _uploadPictures

    private val _currentImageIdx = MutableLiveData<Int>()
    val currentImageIdx: LiveData<Int>
        get() = _currentImageIdx

    private val _writeReviewProgress = MutableLiveData<Int>()
    val writeReviewProgress: LiveData<Int>
        get() = _writeReviewProgress

    private val _selectedTagList = MutableLiveData<List<TagInfoEntity>>(listOf())
    val selectedTagList: LiveData<List<TagInfoEntity>>
        get() = _selectedTagList

    fun initializeImages() {
        _uploadPictures.value = listOf()
    }

    fun changeUploadPictures(pictures: List<Uri>) {
        _uploadPictures.value = pictures
    }

    fun changeCurrentImageIdx(idx: Int) {
        _currentImageIdx.value = idx
    }

    fun changeWriteReviewProgress(step: Int) {
        _writeReviewProgress.value = step
    }

    fun changeSelectedTag(tag: TagInfoEntity) {
        val tags = selectedTagList.value?.toMutableList()
        if (tags?.contains(tag) == true) {
            tags.remove(tag)
        } else {
            tags?.add(tag)
        }
        _selectedTagList.value = tags?.toList()
    }

    fun changeSelectedTagList(tagList: List<TagInfoEntity>) {
        _selectedTagList.value = tagList
    }

}
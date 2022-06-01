package com.sadikahmetozdemir.univera.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.sadikahmetozdemir.univera.base.BaseViewModel
import com.sadikahmetozdemir.univera.core.repository.DefaultRepository
import com.sadikahmetozdemir.univera.core.shared.remote.AlbumPhotosModelItem
import javax.inject.Inject

class HomeDetailViewModel @Inject constructor(
    private var defaultRepository: DefaultRepository,
    private var savedStateHandle: SavedStateHandle,
) :
    BaseViewModel() {
    private var _photos: MutableLiveData<List<AlbumPhotosModelItem>> = MutableLiveData()
    val photos: LiveData<List<AlbumPhotosModelItem>> get() = _photos
    val albumId = savedStateHandle.get<Int>("album")

    suspend fun getPhotos(albumID: Int) {
        sendRequest(request = {
            defaultRepository.getPhotos(albumID)
        },
            success = { _photos.value = it },
            error = { it })
    }


}
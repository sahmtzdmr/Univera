package com.sadikahmetozdemir.univera.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sadikahmetozdemir.univera.base.BaseViewModel
import com.sadikahmetozdemir.univera.core.repository.DefaultRepository
import com.sadikahmetozdemir.univera.core.shared.remote.AlbumResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private var defaultRepository: DefaultRepository) :
    BaseViewModel() {
    private var _albums: MutableLiveData<AlbumResponseModel> = MutableLiveData()
    val albums: LiveData<AlbumResponseModel> get() = _albums

    suspend fun getAlbums() {
        sendRequest(request = { defaultRepository.getAlbums() },
            success = {
                _albums.value = it
            },
            error = { it }
        )
    }
}
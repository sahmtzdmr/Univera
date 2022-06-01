package com.sadikahmetozdemir.univera.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sadikahmetozdemir.univera.base.BaseViewModel
import com.sadikahmetozdemir.univera.core.repository.DefaultRepository
import com.sadikahmetozdemir.univera.core.shared.remote.AlbumResponseModelItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private var defaultRepository: DefaultRepository) :
    BaseViewModel() {
    private var _albums: MutableLiveData<List<AlbumResponseModelItem>> = MutableLiveData()
    val albums: LiveData<List<AlbumResponseModelItem>> get() = _albums

    init {
        getAlbums()
    }

    fun getAlbums() {
        sendRequest(request = { defaultRepository.getAlbums() },
            success = {
                _albums.value = it
            },
            error = { it }
        )
    }

    fun toDetail() {
        navigate(HomeFragmentDirections.actionHomeFragmentToHomeDetailFragment())
    }
}
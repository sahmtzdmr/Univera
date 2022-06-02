package com.sadikahmetozdemir.univera.ui.comment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.sadikahmetozdemir.univera.base.BaseViewModel
import com.sadikahmetozdemir.univera.core.repository.DefaultRepository
import com.sadikahmetozdemir.univera.core.shared.remote.AlbumPhotosModelItem
import com.sadikahmetozdemir.univera.core.shared.remote.CommentResponseModelItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CommentViewModel @Inject constructor(
    private var defaultRepository: DefaultRepository,
    private var savedStateHandle: SavedStateHandle,
) :
    BaseViewModel() {
    private var _comments: MutableLiveData<List<CommentResponseModelItem>> = MutableLiveData()
    val comments: LiveData<List<CommentResponseModelItem>> get() = _comments
    val albumId = savedStateHandle.get<Int>("albumID")

    fun getComments(albumID: Int,page: Int) {
        sendRequest(request = {
            defaultRepository.getComments(albumID, page)
        },
            success = {
                _comments.value = it

            },
            error = { it })
    }


}
package com.sadikahmetozdemir.univera.core.repository

import com.sadikahmetozdemir.univera.core.shared.remote.AlbumResponseModel
import com.sadikahmetozdemir.univera.core.shared.service.AlbumAPI
import javax.inject.Inject

class DefaultRepository @Inject constructor(private var albumAPI: AlbumAPI) : BaseRepository() {
    suspend fun getAlbums(): AlbumResponseModel =
        execute {
            albumAPI.albumResponseRequest()
        }

}

package com.sadikahmetozdemir.univera.core.repository

import com.sadikahmetozdemir.univera.core.shared.remote.AlbumPhotosModelItem
import com.sadikahmetozdemir.univera.core.shared.remote.AlbumResponseModelItem
import com.sadikahmetozdemir.univera.core.shared.remote.CommentResponseModelItem
import com.sadikahmetozdemir.univera.core.shared.service.AlbumAPI
import javax.inject.Inject

class DefaultRepository @Inject constructor(private var albumAPI: AlbumAPI) : BaseRepository() {
    suspend fun getAlbums(): List<AlbumResponseModelItem> =
        execute {
            albumAPI.albumResponseRequest()
        }

    suspend fun getPhotos(albumID: Int): List<AlbumPhotosModelItem> =
        execute {
            albumAPI.albumPhotosRequest(albumID)
        }

    suspend fun getComments(albumID: Int, page :Int): List<CommentResponseModelItem> =
        execute {
            albumAPI.commentsRequest(albumID,page)
        }

}

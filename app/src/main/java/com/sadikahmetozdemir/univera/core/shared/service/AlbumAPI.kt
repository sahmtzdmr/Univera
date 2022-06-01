package com.sadikahmetozdemir.univera.core.shared.service

import com.sadikahmetozdemir.univera.core.shared.remote.AlbumPhotosModelItem
import com.sadikahmetozdemir.univera.core.shared.remote.AlbumResponseModelItem
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumAPI {

    @GET("albums")
    suspend fun albumResponseRequest(): List<AlbumResponseModelItem>

    @GET("albums/{album_id}/photos")

    suspend fun albumPhotosRequest(
        @Path("album_id") albumID: Int,
    ): List<AlbumPhotosModelItem>

}
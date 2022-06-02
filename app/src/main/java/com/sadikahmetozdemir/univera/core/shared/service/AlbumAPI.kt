package com.sadikahmetozdemir.univera.core.shared.service

import com.sadikahmetozdemir.univera.core.shared.remote.AlbumPhotosModelItem
import com.sadikahmetozdemir.univera.core.shared.remote.AlbumResponseModelItem
import com.sadikahmetozdemir.univera.core.shared.remote.CommentResponseModelItem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AlbumAPI {

    @GET("albums")
    suspend fun albumResponseRequest(): List<AlbumResponseModelItem>

    @GET("albums/{album_id}/photos")

    suspend fun albumPhotosRequest(
        @Path("album_id") albumID: Int,
    ): List<AlbumPhotosModelItem>

    @GET("albums/{album_id}/comments")
    suspend fun commentsRequest(
        @Path("album_id") albumID: Int,
        @Query("page") page: Int,
    ): List<CommentResponseModelItem>

}
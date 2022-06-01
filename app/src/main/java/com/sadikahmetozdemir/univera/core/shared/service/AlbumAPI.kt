package com.sadikahmetozdemir.univera.core.shared.service

import com.sadikahmetozdemir.univera.core.shared.remote.AlbumResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumAPI {

    @GET("albums")
    suspend fun albumResponseRequest(): AlbumResponseModel

}
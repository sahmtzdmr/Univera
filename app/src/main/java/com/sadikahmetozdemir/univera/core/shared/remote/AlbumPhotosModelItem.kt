package com.sadikahmetozdemir.univera.core.shared.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AlbumPhotosModelItem(

	@field:SerializedName("albumId")
	val albumId: Int?,

	@field:SerializedName("id")
	val id: Int?,

	@field:SerializedName("title")
	val title: String?,

	@field:SerializedName("url")
	val url: String?,

	@field:SerializedName("thumbnailUrl")
	val thumbnailUrl: String?
) : Parcelable

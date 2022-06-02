package com.sadikahmetozdemir.univera.core.shared.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Auth(
    var token: String?, var username: String?
) : Parcelable

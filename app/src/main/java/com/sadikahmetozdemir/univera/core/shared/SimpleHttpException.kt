package com.sadikahmetozdemir.univera.core.shared

data class SimpleHttpException(
    val code: String?,
    val friendlyMessage: String?
) : Exception()

package com.sadikahmetozdemir.univera.core.shared.exceptions

data class SimpleHttpException(
    val code: String?,
    val friendlyMessage: String?
) : Exception()

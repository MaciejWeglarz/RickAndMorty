package com.maciejweglarz.rickandmortyapp.core.network.adapter

sealed class ApiError {
    data class HttpError(val code: Int, val message: String) : ApiError()
    data class NetworkError(val message: String) : ApiError()
    data class UnknownError(val message: String) : ApiError()
}
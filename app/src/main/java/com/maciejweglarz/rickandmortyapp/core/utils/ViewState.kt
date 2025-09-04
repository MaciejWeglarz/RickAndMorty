package com.maciejweglarz.rickandmortyapp.core.utils

sealed class ViewState<T>(val data: T? = null, val message: String? = null) {
    class Content<T>(data: T): ViewState<T>(data)
    class Error<T>(message: String?): ViewState<T>(message = message)
    class Loading<T>: ViewState<T>()
}
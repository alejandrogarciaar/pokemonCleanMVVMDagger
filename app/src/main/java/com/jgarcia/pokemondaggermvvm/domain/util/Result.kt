package com.jgarcia.pokemondaggermvvm.domain.util

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: ErrorType) : Result<Nothing>()
    object Loading : Result<Nothing>()
}

sealed class ErrorType {
    object NetworkError : ErrorType()
    object SocketTimeoutError : ErrorType()
    object UnknownError : ErrorType()
}
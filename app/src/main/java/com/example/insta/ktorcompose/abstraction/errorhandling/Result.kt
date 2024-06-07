package com.example.insta.ktorcompose.abstraction.errorhandling

sealed class Result<out T> {
    data class InProgress(val isStarted: Boolean) : Result<Nothing>()
    data class Success<out T>(val data: T) : Result<T>()
    data class Failure(val exception: String) : Result<Nothing>()
}

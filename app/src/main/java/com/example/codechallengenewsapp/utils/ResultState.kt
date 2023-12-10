package com.example.codechallengenewsapp.utils
sealed class ResultState<out T> {
    data class Success<T>(val data: T) : ResultState<T>()
    data class Error(val errorMessage: String) : ResultState<Nothing>()
    data class Loading(val isShow: Boolean) : ResultState<Nothing>()
}
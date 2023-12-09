package com.example.codechallengenewsapp.utils

import android.util.Log

inline fun <reified T> T.myLog(message: String) {
    Log.d(T::class.simpleName, message)
}

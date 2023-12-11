package com.example.codechallengenewsapp.utils

import android.content.Context
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso

inline fun <reified T> T.myLog(message: String) {
    Log.d(T::class.simpleName, message)
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun ImageView.loadImageFromUrl(url: String, placeholder: Int) {
    Picasso.get()
        .load(url)
        .fit()
        .centerCrop()
        .placeholder(placeholder)
        .into(this)
}


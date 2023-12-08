package com.example.codechallengenewsapp.data.datasource.network.models

import com.google.gson.annotations.SerializedName

internal data class BaseResponse<T>(
    @SerializedName("status") val status: String,
    @SerializedName("totalResults") val totalResults: Int,
    @SerializedName("articles") val data: List<T>,
)

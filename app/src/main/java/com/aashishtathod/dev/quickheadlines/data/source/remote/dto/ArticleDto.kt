package com.aashishtathod.dev.quickheadlines.data.source.remote.dto

import com.google.gson.annotations.SerializedName

data class ArticleDto(
    val title: String,
    val description: String? = null,
    @SerializedName("url")
    val imageUrl: String? = null
)

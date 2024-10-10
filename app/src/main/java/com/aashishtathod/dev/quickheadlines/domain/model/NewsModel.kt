package com.aashishtathod.dev.quickheadlines.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsModel(
    val title: String,
    val description: String? = null,
    val imageUrl: String? = null
): Parcelable
package com.aashishtathod.dev.quickheadlines.data.source.remote.api

import com.aashishtathod.dev.quickheadlines.data.source.remote.dto.ArticleDto
import com.aashishtathod.dev.quickheadlines.data.source.remote.dto.NewsDto
import com.aashishtathod.dev.quickheadlines.utils.Constants.API_KEY
import com.aashishtathod.dev.quickheadlines.utils.Constants.TOP_HEADLINES_API
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET(TOP_HEADLINES_API)
    suspend fun getTopHeadlines(
        @Query("country")
        country: String = "us",
        @Query("apiKey")
        apiKey: String = API_KEY
    ): NewsDto
}
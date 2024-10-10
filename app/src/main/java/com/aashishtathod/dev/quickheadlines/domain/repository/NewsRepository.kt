package com.aashishtathod.dev.quickheadlines.domain.repository

import com.aashishtathod.dev.quickheadlines.domain.model.NewsModel
import com.aashishtathod.dev.quickheadlines.utils.ApiResponse
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

     fun getTopHeadlines(): Flow<ApiResponse<List<NewsModel>>>

     suspend fun syncTopHeadlines(): ApiResponse<Unit>
}
package com.aashishtathod.dev.quickheadlines.domain.usecase

import com.aashishtathod.dev.quickheadlines.domain.model.NewsModel
import com.aashishtathod.dev.quickheadlines.domain.repository.NewsRepository
import com.aashishtathod.dev.quickheadlines.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTopHeadlinesUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    fun getTopHeadlines(): Flow<ApiResponse<List<NewsModel>>> {
        return repository.getTopHeadlines()
    }
}

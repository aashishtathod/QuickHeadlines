package com.aashishtathod.dev.quickheadlines.domain.usecase

import com.aashishtathod.dev.quickheadlines.domain.repository.NewsRepository
import com.aashishtathod.dev.quickheadlines.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SyncTopHeadlinesUseCase @Inject constructor(
    private val repository: NewsRepository
) {

    operator suspend fun invoke(): ApiResponse<Unit>{
        return repository.syncTopHeadlines()
    }
}
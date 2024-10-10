package com.aashishtathod.dev.quickheadlines.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.aashishtathod.dev.quickheadlines.domain.usecase.SyncTopHeadlinesUseCase
import com.aashishtathod.dev.quickheadlines.utils.ApiResponse
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class NewsSyncWorker @AssistedInject constructor(
    private val syncTopHeadlinesUseCase: SyncTopHeadlinesUseCase,
    @Assisted context: Context,
    @Assisted workerParameters: WorkerParameters
) : CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result {
        return try {
            when (val result = syncTopHeadlinesUseCase()) {
                is ApiResponse.Success -> Result.success()
                else -> Result.failure()
            }
        } catch (e: Exception){
            Result.failure()
        }
    }
}
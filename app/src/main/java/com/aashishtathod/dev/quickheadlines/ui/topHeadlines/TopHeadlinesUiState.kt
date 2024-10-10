package com.aashishtathod.dev.quickheadlines.ui.topHeadlines

import com.aashishtathod.dev.quickheadlines.domain.model.NewsModel

sealed class TopHeadlinesUiState {
    object None: TopHeadlinesUiState()
    object Loading: TopHeadlinesUiState()
    data class Success(val news: List<NewsModel>): TopHeadlinesUiState()
    data class Error(val message: String): TopHeadlinesUiState()
}
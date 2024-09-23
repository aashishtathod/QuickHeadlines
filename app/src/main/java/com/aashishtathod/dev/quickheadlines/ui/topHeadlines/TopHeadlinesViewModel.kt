package com.aashishtathod.dev.quickheadlines.ui.topHeadlines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aashishtathod.dev.quickheadlines.domain.usecase.GetTopHeadlinesUseCase
import com.aashishtathod.dev.quickheadlines.utils.ApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopHeadlinesViewModel @Inject constructor(
    private val getTopHeadlinesUseCase: GetTopHeadlinesUseCase
) : ViewModel() {

    init {
        getTopHeadlines()
    }

    private val _uiState: MutableStateFlow<TopHeadlinesUiState> =
        MutableStateFlow(TopHeadlinesUiState.None)
    val uiState: StateFlow<TopHeadlinesUiState> = _uiState

    fun getTopHeadlines() {
        viewModelScope.launch {
            _uiState.emit(TopHeadlinesUiState.Loading)
            getTopHeadlinesUseCase.getTopHeadlines()
                .catch {
                    // todo
                }
                .collect {
                    when (it) {
                        is ApiResponse.Loading -> {
                            // do nothing
                        }

                        is ApiResponse.Success -> {
                            _uiState.emit(TopHeadlinesUiState.Success(it.data))
                        }

                        is ApiResponse.Failure -> {
                            _uiState.emit(TopHeadlinesUiState.Error(it.errorMessage))
                        }
                    }
                }
        }
    }

}
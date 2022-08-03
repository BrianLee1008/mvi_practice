package com.example.feed_feature.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shared_common_domain.uistate.CommonArticleContentUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class FeedViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(FeedViewModelState(isLoading = true))
    val uiState
        get() = _uiState.map {
            it.toUiState()
        }.stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            _uiState.value.toUiState()
        )

    init {

    }
}

/**
 * UseCase 에서 통신한 결과값대로 ViewModel 에서 State 정의 받아 MVI UiState 로 반환
 * */
private data class FeedViewModelState(
    val isLoading: Boolean = false,
    val feedArticles: List<CommonArticleContentUiState> = emptyList(),
    val error: Throwable? = null
) {
    fun toUiState(): FeedMviUiState = when {

        // 1. 에러 x, 아티클도 있을 경우
        (error == null && feedArticles.isNotEmpty()) ->
            FeedMviUiState.HasArticleList(isLoading = isLoading, articleList = feedArticles)

        // 2. 에러 x, 아티클 없을 경우
        (error == null && feedArticles.isEmpty()) ->
            // 3. 로딩중이거나 로딩중이 아닐 경우
            if (isLoading) FeedMviUiState.Loading else FeedMviUiState.EmptyList(isLoading = isLoading)

        // 4. 그외
        else -> FeedMviUiState.Error(isLoading = isLoading, error = error)

    }
}

/**
 * MVI UiState
 * */
sealed interface FeedMviUiState {
    val isLoading: Boolean

    data class HasArticleList(
        override val isLoading: Boolean,
        val articleList: List<CommonArticleContentUiState>,
    ) : FeedMviUiState

    data class EmptyList(
        override val isLoading: Boolean
    ) : FeedMviUiState

    data class Error(
        override val isLoading: Boolean,
        val error: Throwable?
    ) : FeedMviUiState

    object Loading : FeedMviUiState {
        override val isLoading: Boolean = false
    }
}
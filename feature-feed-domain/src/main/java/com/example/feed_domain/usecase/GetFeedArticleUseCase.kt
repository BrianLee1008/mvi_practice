package com.example.feed_domain.usecase

import com.example.shared_common_domain.uistate.CommonArticleContentUiState
import com.example.shared_foundation.uistate.ScreenUiState
import com.example.shared_foundation.usecase.CommonUseCase
import com.example.shared_foundation.usecase.UseCaseAction

interface GetFeedArticleUseCase : CommonUseCase<GetFeedArticleUseCaseAction, FeedMviUiState> {
}

data class GetFeedArticleUseCaseAction(
    val isLoading: Boolean = false,
    val feedArticles: List<CommonArticleContentUiState> = emptyList(),
    val error: Throwable? = null
) : UseCaseAction

/**
 * MVI UiState
 * */
sealed interface FeedMviUiState : ScreenUiState {
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
        override val isLoading: Boolean = true
    }
}
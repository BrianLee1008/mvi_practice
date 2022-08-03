package com.example.feed_feature.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feed_domain.usecase.FeedMviUiState
import com.example.feed_domain.usecase.GetFeedArticleUseCase
import com.example.feed_domain.usecase.GetFeedArticleUseCaseAction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val getFeedArticleUseCase: GetFeedArticleUseCase
): ViewModel() {

    // UseCase 에서 데이터 처리후 흘려보내주는 State observe
    val uiState = getFeedArticleUseCase.observe()
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            FeedMviUiState.Loading
        )

    // UseCase Invoke 하여 Action 보내기
    fun getFeedArticle() {
        viewModelScope.launch {
            getFeedArticleUseCase(GetFeedArticleUseCaseAction(isLoading = false))
        }
    }
}
package com.example.feed_feature.view.feed

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feed_domain.usecase.FeedMviUiState
import com.example.feed_feature.viewmodel.FeedViewModel

@Composable
fun FeedRoute() {

    val feedViewModel = hiltViewModel<FeedViewModel>()
    val uiState by feedViewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        feedViewModel.getFeedArticle()
    }

    when (val mviState: FeedMviUiState = uiState) {
        is FeedMviUiState.HasArticleList -> {
            FeedScreen(
                stateHolder = rememberFeedUiStateHolder(
                    hasCommonArticle = true, // 아티클 있는지 없는지
                    uiStateList = mviState.articleList, // uiStateList
                    nextButtonClickListener = { /*TODO*/ }, // 다음버튼 클릭리스너
                    nextButtonEnabled = true // 다음버튼 활성화여부
                )
            )
        }

        is FeedMviUiState.EmptyList -> {
            FeedScreen(
                stateHolder = rememberFeedUiStateHolder(
                    hasCommonArticle = false, // 아티클 있는지 없는지
                    uiStateList = emptyList(), // uiStateList
                    nextButtonClickListener = { /*TODO*/ }, // 다음버튼 클릭리스너
                    nextButtonEnabled = false// 다음버튼 활성화여부
                )
            )
        }

        is FeedMviUiState.Error -> {
            /* Error... */
            Log.d("UiStateTest", "${mviState.error?.message}")
        }

        is FeedMviUiState.Loading -> {
            /* Loading ... */
            Log.d("UiStateTest", "${mviState.isLoading}")
        }
    }
}
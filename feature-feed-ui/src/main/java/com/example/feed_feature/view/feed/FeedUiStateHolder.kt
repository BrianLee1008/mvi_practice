package com.example.feed_feature.view.feed

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import com.example.shared_common_domain.uistate.CommonArticleContentUiState

@Stable
data class FeedUiStateHolder(
    val hasCommonArticle: Boolean,
    val uiStateList: List<CommonArticleContentUiState>,
    val nextButtonClickListener: () -> Unit,
    val nextButtonEnabled: Boolean
)


@Composable
fun rememberFeedUiStateHolder(
    hasCommonArticle: Boolean,
    uiStateList: List<CommonArticleContentUiState>,
    nextButtonClickListener: () -> Unit,
    nextButtonEnabled: Boolean
): FeedUiStateHolder {

    return remember(
        hasCommonArticle,
        uiStateList,
        nextButtonEnabled,
        nextButtonClickListener
    ) {
        FeedUiStateHolder(
            hasCommonArticle = hasCommonArticle,
            uiStateList = uiStateList,
            nextButtonClickListener = nextButtonClickListener,
            nextButtonEnabled = nextButtonEnabled
        )
    }
}
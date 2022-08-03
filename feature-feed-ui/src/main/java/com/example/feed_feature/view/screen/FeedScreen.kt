package com.example.feed_feature.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.example.shared_common_domain.uistate.CommonArticleContentUiState
import com.example.shared_common_ui.component.FeedCommonArticle1
import com.example.shared_common_ui.preview.CommonArticleListDummyData

@Composable
fun FeedScreen(
    modifier : Modifier = Modifier,
    hasCommonArticle: Boolean,
    uiStateList: List<CommonArticleContentUiState>
) {
    Column(modifier.fillMaxSize()
        .background(color = MaterialTheme.colors.surface)) {
        if (hasCommonArticle) {
            uiStateList.forEach{
                FeedCommonArticle1(uiState = it)
            }
        } else {
            Text(text = "FEED IS EMPTY")
        }
    }
}

/***************************
 * PREVIEW
 ***************************/


@Preview
@Composable
fun PreviewFeedScreen(
    @PreviewParameter(CommonArticleListDummyData::class) dummyData: List<CommonArticleContentUiState>
) {
    FeedScreen(hasCommonArticle = true, uiStateList = dummyData)
}
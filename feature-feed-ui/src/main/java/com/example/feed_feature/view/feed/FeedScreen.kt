package com.example.feed_feature.view.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.feed_feature.component.NextButton
import com.example.feed_feature.preview.dummydata.FeedUiStateHolderDummyData
import com.example.shared_common_ui.component.FeedCommonArticle1

@Composable
fun FeedScreen(
    modifier: Modifier = Modifier,
    stateHolder: FeedUiStateHolder
) {
    ConstraintLayout(
        modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.surface)
            .padding(40.dp, 20.dp)
    ) {
        val (topContent, nextButton) = createRefs()

        Column(
            modifier = Modifier
                .constrainAs(topContent) {
                    top.linkTo(parent.top)
                    linkTo(start = parent.start, end = parent.end)
                }
        ) {
            if (stateHolder.hasCommonArticle) {
                stateHolder.uiStateList.forEach {
                    FeedCommonArticle1(uiState = it)
                }
            } else {
                Text(text = "FEED IS EMPTY")
            }
        }

        NextButton(
            modifier = Modifier
                .constrainAs(nextButton) {
                    linkTo(top = topContent.bottom, bottom = parent.bottom, bias = 1f)
                    linkTo(start = parent.start, end = parent.end)
                },
            buttonTitle = "NextButton",
            clickListener = stateHolder.nextButtonClickListener,
            enabled = stateHolder.nextButtonEnabled
        )

    }
}

/***************************
 * PREVIEW
 ***************************/


@Preview
@Composable
fun PreviewFeedScreen(
    @PreviewParameter(FeedUiStateHolderDummyData::class) dummyData: FeedUiStateHolder
) {
    FeedScreen(
        stateHolder = dummyData
    )
}
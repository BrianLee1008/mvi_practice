package com.example.shared_common_ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FeedCommonArticle1(
    modifier: Modifier = Modifier,
    articleTitle : String
) {
    Row(
        modifier = modifier
            .padding(12.dp)
    ) {
        Text(text = articleTitle)
    }
}

/***************************
 * PREVIEW
 ***************************/

@Preview
@Composable
fun PreviewFeedCommonArticle1() {
    FeedCommonArticle1(articleTitle = "test")
}
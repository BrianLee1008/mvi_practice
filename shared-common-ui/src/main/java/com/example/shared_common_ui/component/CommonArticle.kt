package com.example.shared_common_ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shared_common_ui.util.dpToSp

@Composable
fun FeedCommonArticle1(
    modifier: Modifier = Modifier,
    articleTitle: String,
    articleDescription: String
) {
    Row(
        modifier = modifier
            .padding(12.dp)
            .background(MaterialTheme.colors.onSurface),
    ) {

        Text(
            text = articleTitle, fontWeight = FontWeight.Normal,
            fontSize = 20.dpToSp(),
            color = MaterialTheme.colors.surface
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = articleDescription,
            fontSize = 14.dpToSp(),
            color = MaterialTheme.colors.surface
        )
    }
}

/***************************
 * PREVIEW
 ***************************/

@Preview
@Composable
fun PreviewFeedCommonArticle1() {
    FeedCommonArticle1(articleTitle = "title", articleDescription = "description")
}
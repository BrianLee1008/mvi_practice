package com.example.feed_feature.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun NextButton(
    modifier: Modifier = Modifier,
    buttonTitle: String,
    clickListener: () -> Unit,
    enabled: Boolean
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        onClick = clickListener,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.onSecondary
        ),
        enabled = enabled
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterVertically),
            color = MaterialTheme.colors.secondary,
            fontWeight = FontWeight.Bold,
            text = buttonTitle
        )
    }
}

/***************************
 * PREVIEW
 ***************************/

@Preview
@Composable
fun PreviewNextButton() {
    NextButton(buttonTitle = "button title", clickListener = { /*TODO*/ }, enabled = true)

}
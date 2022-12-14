package com.example.feed_feature.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.feed_feature.view.feed.FeedRoute
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FeedRoute()
        }
    }
}
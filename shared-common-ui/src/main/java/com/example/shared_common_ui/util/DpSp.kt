package com.example.shared_common_ui.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun Dp.toSp() = with(LocalDensity.current) { this@toSp.toSp() }

@Composable
fun Int.dpToSp() = Dp(value = this.toFloat()).toSp()

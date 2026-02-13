package com.andha_coder.firstcompose.models

import androidx.annotation.Keep


@Keep
data class Quote(
    val author: String,
    val text: String
)
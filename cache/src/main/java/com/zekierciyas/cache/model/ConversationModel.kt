package com.zekierciyas.cache.model

import androidx.annotation.DrawableRes

data class ConversationModel(
    val id: Int,
    val name: String,
    val message: String,
    @DrawableRes val photo: Int
)

package com.zekierciyas.cache.model

import androidx.annotation.DrawableRes

data class HomeFeedData(
    val userName: String,
    @DrawableRes val postImage: Int,
    val postedTime: String,
    val favoriteCount: String,
    val commentCount: String,
    val savingCount: String
)

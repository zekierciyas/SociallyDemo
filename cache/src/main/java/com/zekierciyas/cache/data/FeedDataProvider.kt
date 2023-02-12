package com.zekierciyas.cache.data

import com.zekierciyas.cache.R
import com.zekierciyas.cache.model.HomeFeedData

class FeedDataProvider {
    val data = listOf(
        HomeFeedData(
            userName = "Dennis Reynolds",
            postImage = R.drawable.dummy_post_1,
            postedTime = "2 hrs ago",
            favoriteCount = "5.2K",
            commentCount = "1.1K",
            savingCount = "362"
        ),

        HomeFeedData(
            userName = "Charlie Kelly",
            postImage = R.drawable.dummy_post_2,
            postedTime = "4 hrs ago",
            favoriteCount = "5.2K",
            commentCount = "1.1K",
            savingCount = "362"
        )
    )
}
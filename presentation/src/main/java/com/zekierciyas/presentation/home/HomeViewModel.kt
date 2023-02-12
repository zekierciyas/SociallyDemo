package com.zekierciyas.presentation.home

import androidx.lifecycle.ViewModel
import com.zekierciyas.cache.data.FeedDataProvider
import com.zekierciyas.cache.data.StoryDataProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dummyData: StoryDataProvider ,
    private val dummyFeedData: FeedDataProvider
    ): ViewModel() {

    fun getStoryData() : StoryDataProvider = dummyData

    fun getFeedData() : FeedDataProvider = dummyFeedData
}
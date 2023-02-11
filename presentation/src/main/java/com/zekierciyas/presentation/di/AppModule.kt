package com.zekierciyas.presentation.di

import com.zekierciyas.presentation.conversations.ConversationsAdapter
import com.zekierciyas.presentation.home.StoryListAdapter
import com.zekierciyas.presentation.profile.HomeFeedListAdapter
import com.zekierciyas.presentation.profile.PhotoListAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun providePhotoListAdapter(): PhotoListAdapter = PhotoListAdapter()

    @Provides
    @Singleton
    fun provideStoryListAdapter(): StoryListAdapter = StoryListAdapter()

    @Provides
    @Singleton
    fun provideHomeFeedListAdapter(): HomeFeedListAdapter = HomeFeedListAdapter()

    @Provides
    @Singleton
    fun provideConversationsListAdapter(): ConversationsAdapter = ConversationsAdapter()
}
package com.zekierciyas.cache.di

import com.zekierciyas.cache.data.FeedDataProvider
import com.zekierciyas.cache.data.ProfileDataProvider
import com.zekierciyas.cache.data.StoryDataProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    @Singleton
    fun provideDummyProfile() : ProfileDataProvider = ProfileDataProvider()

    @Provides
    @Singleton
    fun provideDummyStories() : StoryDataProvider = StoryDataProvider()

    @Provides
    @Singleton
    fun provideDummyFeed() : FeedDataProvider = FeedDataProvider()


}
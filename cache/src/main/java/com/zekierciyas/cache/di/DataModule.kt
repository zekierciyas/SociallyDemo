package com.zekierciyas.cache.di

import com.zekierciyas.cache.data.ProfileDataProvider
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


}
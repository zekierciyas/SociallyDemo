package com.zekierciyas.presentation.di

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
}
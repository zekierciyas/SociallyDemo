package com.zekierciyas.presentation.profile

import androidx.lifecycle.ViewModel
import com.zekierciyas.cache.data.ProfileDataProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val dummyData: ProfileDataProvider
): ViewModel() {


    fun getData(): ProfileDataProvider = dummyData
}
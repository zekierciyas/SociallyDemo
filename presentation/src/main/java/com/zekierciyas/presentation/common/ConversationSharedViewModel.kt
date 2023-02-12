package com.zekierciyas.presentation.common

import androidx.lifecycle.ViewModel
import com.zekierciyas.cache.data.ConversationsDataProvider
import com.zekierciyas.cache.model.ConversationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ConversationSharedViewModel @Inject constructor(
    private val dummyData: ConversationsDataProvider
): ViewModel() {

    var currentSelectedConversation: ConversationModel? = null

    fun getConversationData(): ConversationsDataProvider = dummyData

}
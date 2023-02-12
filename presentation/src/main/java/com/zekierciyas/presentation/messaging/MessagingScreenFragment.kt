package com.zekierciyas.presentation.messaging

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.zekierciyas.base.setDrawable
import com.zekierciyas.base.viewBinding
import com.zekierciyas.presentation.R
import com.zekierciyas.presentation.common.ConversationSharedViewModel
import com.zekierciyas.presentation.databinding.MessagingScreenBinding
import com.zekierciyas.presentation.databinding.ProfileScreenBinding
import com.zekierciyas.presentation.profile.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MessagingScreenFragment: Fragment(R.layout.messaging_screen) {

    private val binding by viewBinding(MessagingScreenBinding::bind)
    private val viewModel by activityViewModels<ConversationSharedViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupMessagingRecyclerView()

        setUI()

    }

    private fun setUI() {
        binding.senderPhoto.setDrawable(viewModel.currentSelectedConversation!!.photo)
        binding.senderName.text = viewModel.currentSelectedConversation!!.name
    }

    private fun setupMessagingRecyclerView() {
        binding.recyclerViewMessaging.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
        val adapter = MessagingAdapter(viewModel.currentSelectedConversation!!.messages)
        binding.recyclerViewMessaging.adapter = adapter
    }
}
package com.zekierciyas.presentation.messaging

import android.os.Bundle
import android.view.View
import android.view.View.OnFocusChangeListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.internal.ViewUtils.hideKeyboard
import com.zekierciyas.base.hideSoftKeyboard
import com.zekierciyas.base.setDrawable
import com.zekierciyas.base.viewBinding
import com.zekierciyas.presentation.R
import com.zekierciyas.presentation.common.ConversationSharedViewModel
import com.zekierciyas.presentation.databinding.MessagingScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MessagingScreenFragment: Fragment(R.layout.messaging_screen) {

    private val binding by viewBinding(MessagingScreenBinding::bind)
    private val viewModel by activityViewModels<ConversationSharedViewModel>()
    private lateinit var adapter: MessagingAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupMessagingRecyclerView()

        setUI()

        handleClickEvent()
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
        adapter = MessagingAdapter(viewModel.currentSelectedConversation!!.messages)
        binding.recyclerViewMessaging.adapter = adapter
    }

    private fun handleClickEvent() {
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

       binding.buttonSendMessage.setOnClickListener {
           hideSoftKeyboard()
           adapter.sendMessage(binding.editTextMessage.text.toString())
           binding.editTextMessage.text.clear()
       }
    }
}
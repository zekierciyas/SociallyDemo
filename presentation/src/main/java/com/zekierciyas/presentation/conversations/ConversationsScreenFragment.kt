package com.zekierciyas.presentation.conversations

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.zekierciyas.base.viewBinding
import com.zekierciyas.presentation.R
import com.zekierciyas.presentation.common.ConversationSharedViewModel
import com.zekierciyas.presentation.databinding.ConversationsScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ConversationsScreenFragment: Fragment(R.layout.conversations_screen) {

    private val binding by viewBinding(ConversationsScreenBinding::bind)
    private val viewModel by activityViewModels<ConversationSharedViewModel>()

    var adapter: ConversationsAdapter? = null
        @Inject set

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupStoryRecyclerView()

        handleClickEvent()
    }

    private fun setupStoryRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
        //Setting Adapter to RecyclerView
        adapter!!.provideData(viewModel.getConversationData())
        binding.recyclerView.adapter = adapter
    }

    private fun handleClickEvent() {
        //Observing recyclerView click events
        adapter!!.onItemClick = {
            //Setting the selected data to shared viewModel
            viewModel.currentSelectedConversation = it
            //Navigation to MessagingFragment
            findNavController().navigate(R.id.action_conversationsScreenFragment_to_messagingScreenFragment)
        }
    }
}
package com.zekierciyas.presentation.conversations

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.zekierciyas.base.hideSoftKeyboard
import com.zekierciyas.base.viewBinding
import com.zekierciyas.presentation.R
import com.zekierciyas.presentation.common.ConversationSharedViewModel
import com.zekierciyas.presentation.databinding.ConversationsScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConversationsScreenFragment: Fragment(R.layout.conversations_screen) {

    private val binding by viewBinding(ConversationsScreenBinding::bind)
    private val viewModel by activityViewModels<ConversationSharedViewModel>()

    private lateinit var adapter: ConversationsAdapter

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
        adapter = ConversationsAdapter(viewModel.getConversationData())
        binding.recyclerView.adapter = adapter
    }

    private fun handleClickEvent() {
        //Observing recyclerView click events
        adapter.onItemClick = {
            //Setting the selected data to shared viewModel
            viewModel.currentSelectedConversation = it
            //Navigation to MessagingFragment
            findNavController().navigate(R.id.action_conversationsScreenFragment_to_messagingScreenFragment)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                hideSoftKeyboard()
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                //Allows character changes to pass into the adapter class
                adapter.filter.filter(newText)
                return false
            }
        })

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

    }

}
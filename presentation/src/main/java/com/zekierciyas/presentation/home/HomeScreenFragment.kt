package com.zekierciyas.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDestination
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.zekierciyas.base.viewBinding
import com.zekierciyas.presentation.R
import com.zekierciyas.presentation.databinding.HomeScreenBinding
import com.zekierciyas.presentation.profile.HomeFeedListAdapter
import com.zekierciyas.presentation.profile.PhotoListAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeScreenFragment: Fragment(R.layout.home_screen) {

    private val binding by viewBinding(HomeScreenBinding::bind)
    private val viewModel by viewModels<HomeViewModel>()

    var adapter: StoryListAdapter? = null
        @Inject set

    var adapterFeed: HomeFeedListAdapter? = null
    @Inject set

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupStoryRecyclerView()

        setupFeedRecyclerView()

        navBarClickListener()
    }

    private fun setupStoryRecyclerView() {
        binding.storyHorizontalScrollView.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        // Sending reference and data to Adapter
        // Setting Adapter to RecyclerView
        adapter!!.provideData(viewModel.getStoryData())
        binding.storyHorizontalScrollView.adapter = adapter
    }

    private fun setupFeedRecyclerView() {
        binding.feedVerticalScrollView.layoutManager = LinearLayoutManager (
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )

        adapterFeed!!.provideData(viewModel.getFeedData().data)
        binding.feedVerticalScrollView.adapter = adapterFeed
    }

    private fun navBarClickListener() {
        binding.bottom.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.profile -> {
                    findNavController().navigate(R.id.action_homeScreenFragment_to_profileScreenFragment)
                    true
                }

                R.id.messages -> {
                    findNavController().navigate(R.id.action_global_conversationsScreenFragment)
                    true
                }
                else -> {true}
            }

        }
    }

    override fun onResume() {
        super.onResume()
        //Setting default checked item when life cycle onResumed()
        binding.bottom.bottomNavigationView.menu.findItem(R.id.home).isChecked = true
    }
}
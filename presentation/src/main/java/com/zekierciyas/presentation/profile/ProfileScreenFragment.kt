package com.zekierciyas.presentation.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.zekierciyas.base.viewBinding
import com.zekierciyas.cache.ProfileDataProvider
import com.zekierciyas.presentation.R
import com.zekierciyas.presentation.databinding.ProfileScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class ProfileScreenFragment: Fragment(R.layout.profile_screen) {

    //private val viewModel by viewModels<ProfileViewModel>()

   var profileDataProvider: ProfileDataProvider? = null
       @Inject set


    private val binding by viewBinding(ProfileScreenBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerview()
    }

    private fun setupRecyclerview() {
        // Setting the layout as Staggered Grid for vertical orientation
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        binding.recyclerView.layoutManager = staggeredGridLayoutManager
        // Sending reference and data to Adapter
        // Setting Adapter to RecyclerView
        val adapter = PhotoListAdapter()
        adapter.provideData(profileDataProvider!!)
        binding.recyclerView.adapter = adapter

    }
}
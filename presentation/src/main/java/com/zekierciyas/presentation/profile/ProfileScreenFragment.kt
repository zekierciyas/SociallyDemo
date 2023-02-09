package com.zekierciyas.presentation.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.zekierciyas.base.viewBinding
import com.zekierciyas.presentation.R
import com.zekierciyas.presentation.databinding.ProfileScreenBinding


class ProfileScreenFragment: Fragment(R.layout.profile_screen) {

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
        val adapter = PhotoListAdapter(listOf(R.drawable.ic_button_back, R.drawable.ic_button_back))
        // Setting Adapter to RecyclerView
        binding.recyclerView.adapter = adapter
    }
}
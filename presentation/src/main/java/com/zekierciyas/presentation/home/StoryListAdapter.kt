package com.zekierciyas.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zekierciyas.base.setDrawable
import com.zekierciyas.cache.data.StoryDataProvider
import com.zekierciyas.presentation.databinding.StoryListItemBinding
import dagger.hilt.android.scopes.FragmentScoped

@FragmentScoped
class StoryListAdapter(
) : RecyclerView.Adapter<StoryListAdapter.ViewHolder>() {

    private lateinit var dummyData: StoryDataProvider

    inner class ViewHolder(val binding: StoryListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = StoryListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
 
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(dummyData.data[position]){
                binding.imageView.setDrawable(drawable = this)
            }
        }
    }
 
    override fun getItemCount(): Int {
        return dummyData.data.size
    }

    fun provideData(dummyData: StoryDataProvider) {
        this.dummyData = dummyData
    }
}
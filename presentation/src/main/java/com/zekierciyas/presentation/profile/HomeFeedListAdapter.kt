package com.zekierciyas.presentation.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zekierciyas.base.setDrawable
import com.zekierciyas.cache.model.HomeFeedData
import com.zekierciyas.presentation.databinding.HomePageFeedItemBinding

class HomeFeedListAdapter : RecyclerView.Adapter<HomeFeedListAdapter.ViewHolder>() {

    private var dummyData = listOf<HomeFeedData>()

    inner class ViewHolder(val binding: HomePageFeedItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HomePageFeedItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(dummyData[position]){
                binding.postImageView.setDrawable(drawable = this.postImage)
            }
        }
    }

    override fun getItemCount(): Int {
        return dummyData.size
    }

    fun provideData(dummyData: List<HomeFeedData>) {
        this.dummyData = dummyData
    }
}
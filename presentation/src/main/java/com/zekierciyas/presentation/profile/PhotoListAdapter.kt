package com.zekierciyas.presentation.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zekierciyas.base.setDrawable
import com.zekierciyas.cache.data.ProfileDataProvider
import com.zekierciyas.presentation.databinding.ProfileListItemBinding
import dagger.hilt.android.scopes.FragmentScoped

@FragmentScoped
class PhotoListAdapter(
) : RecyclerView.Adapter<PhotoListAdapter.ViewHolder>() {

    private var dummyData = listOf<Int>()

    inner class ViewHolder(val binding: ProfileListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProfileListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
 
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(dummyData[position]){
                binding.imageView.setDrawable(drawable = this)
            }
        }
    }
 
    override fun getItemCount(): Int {
        return dummyData.size
    }

    fun provideData(dummyData: List<Int>) {
        this.dummyData = dummyData
    }
}
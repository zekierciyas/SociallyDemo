package com.zekierciyas.presentation.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zekierciyas.base.setDrawable
import com.zekierciyas.cache.ProfileDataProvider
import com.zekierciyas.presentation.databinding.ProfileListItemBinding
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject
import javax.inject.Singleton

@FragmentScoped
class PhotoListAdapter(
) : RecyclerView.Adapter<PhotoListAdapter.ViewHolder>() {

    private lateinit var dummyData: ProfileDataProvider

    inner class ViewHolder(val binding: ProfileListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProfileListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
 
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

    fun provideData(dummyData: ProfileDataProvider) {
        this.dummyData = dummyData
    }
}
package com.zekierciyas.presentation.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zekierciyas.base.setDrawable
import com.zekierciyas.presentation.databinding.ProfileListItemBinding

class PhotoListAdapter(
    var photoList: List<Int>,
) : RecyclerView.Adapter<PhotoListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ProfileListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProfileListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
 
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(photoList[position]){
                binding.imageView.setDrawable(drawable = this)
            }
        }
    }
 
    override fun getItemCount(): Int {
        return photoList.size
    }
}
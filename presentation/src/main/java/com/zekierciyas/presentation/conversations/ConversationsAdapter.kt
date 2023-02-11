package com.zekierciyas.presentation.conversations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zekierciyas.base.listen
import com.zekierciyas.base.setDrawable
import com.zekierciyas.cache.data.ConversationsDataProvider
import com.zekierciyas.cache.model.ConversationModel
import com.zekierciyas.presentation.databinding.ConversationsListItemBinding
import dagger.hilt.android.scopes.FragmentScoped

@FragmentScoped
class ConversationsAdapter(
) : RecyclerView.Adapter<ConversationsAdapter.ViewHolder>() {

    var onItemClick: ((ConversationModel) -> Unit)? = null

    private lateinit var dummyData: ConversationsDataProvider

    inner class ViewHolder(val binding: ConversationsListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ConversationsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(dummyData.data[position]){
                binding.profilePhoto.setDrawable(drawable = this.photo)
                binding.textMessage.text = this.message
                binding.textName.text = this.name
            }
        }
    }
 
    override fun getItemCount(): Int {
        return dummyData.data.size
    }

    fun provideData(dummyData: ConversationsDataProvider) {
        this.dummyData = dummyData
    }
}
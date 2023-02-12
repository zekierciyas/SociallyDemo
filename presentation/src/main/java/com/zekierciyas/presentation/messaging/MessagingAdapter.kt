package com.zekierciyas.presentation.messaging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zekierciyas.base.inVisible
import com.zekierciyas.base.reVisible
import com.zekierciyas.base.setDrawable
import com.zekierciyas.cache.model.Message
import com.zekierciyas.cache.model.MessageType
import com.zekierciyas.presentation.conversations.ConversationsAdapter
import com.zekierciyas.presentation.databinding.ListItemMessageBinding
import dagger.hilt.android.scopes.FragmentScoped

@FragmentScoped
class MessagingAdapter internal constructor(
    messages: List<Message>
) : RecyclerView.Adapter<MessagingAdapter.ViewHolder>()  {

    private val listMessage = arrayListOf<Message>()

    init {
        listMessage.addAll(messages)
    }

    inner class ViewHolder(val binding: ListItemMessageBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(listMessage[position]){
                when (this.type) {
                    MessageType.SENT -> {
                        binding.messageTextSent.text = this.text
                        binding.messageTextSent.reVisible()
                        binding.messageTextReceived.inVisible()
                    }

                    MessageType.RECEIVED -> {
                        binding.messageTextReceived.text = this.text
                        binding.messageTextReceived.reVisible()
                        binding.messageTextSent.inVisible()
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return listMessage.size
    }

    fun updateList(newList: List<Message>) {
        this.listMessage.addAll(newList.requireNoNulls())
    }

}



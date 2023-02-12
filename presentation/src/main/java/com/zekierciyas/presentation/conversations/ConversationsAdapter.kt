package com.zekierciyas.presentation.conversations

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.zekierciyas.base.listen
import com.zekierciyas.base.setDrawable
import com.zekierciyas.cache.data.ConversationsDataProvider
import com.zekierciyas.cache.model.ConversationModel
import com.zekierciyas.presentation.databinding.ConversationsListItemBinding
import dagger.hilt.android.scopes.FragmentScoped
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

@FragmentScoped
class ConversationsAdapter @Inject constructor(
    private var dummyData: ConversationsDataProvider
) : RecyclerView.Adapter<ConversationsAdapter.ViewHolder>(), Filterable {

    var onItemClick: ((ConversationModel) -> Unit)? = null

    /** Holds the data that can be filtered */
    private var filteredList = arrayListOf<ConversationModel>()

    init {
        filteredList.addAll(dummyData.data)
    }

    inner class ViewHolder(val binding: ConversationsListItemBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ConversationsListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding).listen { pos, type ->
            onItemClick!!.invoke(filteredList[pos])
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(filteredList[position]){
                binding.profilePhoto.setDrawable(drawable = this.photo)
                binding.textMessage.text = this.message
                binding.textName.text = this.name
            }
        }
    }
 
    override fun getItemCount(): Int {
        return filteredList.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    filteredList.clear()
                    filteredList.addAll(dummyData.data)
                } else {
                    val resultList = ArrayList<ConversationModel>()
                    val list = dummyData.data
                    for (row in list) {
                        if (row.name.toLowerCase(Locale.ROOT).contains(charSearch.toLowerCase(Locale.ROOT))) {
                            resultList.add(row)
                        }
                    }
                    filteredList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = filteredList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredList = results?.values as ArrayList<ConversationModel>
                notifyDataSetChanged()
            }
        }
    }
}
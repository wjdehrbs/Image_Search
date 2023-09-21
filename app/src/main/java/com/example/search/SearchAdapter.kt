package com.example.search

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.search.data.SearchItemData
import com.example.search.databinding.SearchItemBinding

class SearchAdapter : RecyclerView.Adapter<SearchViewHolder>() {

    var items = ArrayList<SearchItemData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding =
            SearchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {

        val currentItem = items[position]
        Glide.with(holder.itemView)
            .load(currentItem.url)
            .into(holder.sc_image)
        holder.sc_info.text = currentItem.title
        holder.sc_day.text = currentItem.dataTime

    }

    override fun getItemCount(): Int {
        return items.size
    }
}
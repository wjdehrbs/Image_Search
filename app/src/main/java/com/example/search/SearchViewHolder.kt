package com.example.search

import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.search.databinding.SearchItemBinding

class SearchViewHolder(private val binding: SearchItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    val sc_image: ImageView = binding.scImage
    val sc_info: TextView = binding.scInfo
    val sc_day: TextView = binding.scDay
}